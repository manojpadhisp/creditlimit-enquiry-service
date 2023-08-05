Client_Details: Table
id integer not null
name varchar(100) not null
Description varchar(100) NULL

INSERT INTO javadb.client_details
(id, Name, Description)
VALUES(1, 'web', 'clint is from net banking');

INSERT INTO javadb.client_details
(id, Name, Description)
VALUES(2, 'IVR', 'clint is from customer care');

INSERT INTO javadb.client_details
(id, Name, Description)
VALUES(2, 'Mobile', 'clint is from mobile');
=========================================================

Channel_Details Table:
CREATE TABLE javadb.Channel_Details (
	id INTEGER NOT NULL,
	Name varchar(100) NOT NULL,
	Description varchar(100) NULL
)



INSERT INTO javadb.channel_details
(id, Name, Description)
VALUES(1, 'online', 'online request');

INSERT INTO javadb.channel_details
(id, Name, Description)
VALUES(2, 'offline', 'offline request');

===================================================
Promocode_Info
CREATE TABLE javadb.Promocode_Info (
	Customerid INTEGER NOT NULL,
	Firstname varchar(100) NOT NULL,
	Lastname varchar(100) NOT NULL,
	MobileNo varchar(100) NOT NULL,
	Dateofbirth varchar(20) NOT NULL,
	Cardnum varchar(100) NOT NULL,
	cvv INTEGER NOT NULL,
	Nameoncard varchar(100) NOT NULL,
	Expdate varchar(20) NOT NULL,
	Promocode BIGINT NOT NULL
)
========================================================

///Procedure
enquiry_V10001

DROP PROCEDURE IF EXISTS javadb.enquiry_V10001;

DELIMITER $$
$$
CREATE PROCEDURE javadb.enquiry_V10001( in client_id_in varchar(10),
										in channel_id_in varchar(10),
										in promocode_in varchar(10),
										out respcode_out varchar(10),
										out respmsg_out varchar(10))
begin
	
declare client_id_count INT;
declare channel_id_count INT;
declare promocode_count  INT;

 select count(*) into client_id_count from client_details where Name=client_id_in;
 if client_id_count =0 then
   set respcode_out ='100';
   set respmsg_out = 'Invalid Client id';
end if;

 select count(*) into channel_id_count from channel_details where Name=channel_id_in;
 if channel_id_count =0 then
   set respcode_out ='101';
   set respmsg_out = 'Invalid channel id';
end if;

 select count(*) into promocode_count from promocode_info where Promocode=promocode_in;
 if promocode_count =0 then
   set respcode_out ='102';
   set respmsg_out = 'Invalid promocode id';
end if;

select *from promocode_info where Promocode=promocode_in;

set respcode_out ='0';
set respmsg_out = 'success';
  

END$$
DELIMITER ;
