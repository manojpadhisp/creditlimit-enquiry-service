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
////////////////////////////////////////////////
DELIMITER $$
$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `javadb`.`enquiry_V10001`( in client_id_in varchar(10),
										in channel_id_in varchar(10),
										in promocode_in varchar(20),
										out respcode_out varchar(10),
										out respmsg_out varchar(100))
PROC_LABEL:begin
	
declare client_id_count INT;
declare channel_id_count INT;
declare promocode_count  INT;

 select count(*) into client_id_count from client_details where Name=client_id_in;
 if client_id_count =0 then
   set respcode_out ='100';
   set respmsg_out = 'Invalid Client id';
  LEAVE PROC_LABEL;
end if;

 select count(*) into channel_id_count from channel_details where Name=channel_id_in;
 if channel_id_count =0 then
   set respcode_out ='101';
   set respmsg_out = 'Invalid channel id';
  LEAVE PROC_LABEL;
end if;

 select count(*) into promocode_count from promocode_info where Promocode=promocode_in;
 if promocode_count =0 then
   set respcode_out ='102';
   set respmsg_out = 'Invalid promocode id';
  LEAVE PROC_LABEL;
end if;

select *from promocode_info where Promocode=promocode_in;

set respcode_out ='0';
set respmsg_out = 'success';
  

END$$
DELIMITER ;
//////////////////////////////////////////////////////////////////////

INSERT INTO javadb.promocode_info
(Customerid, Firstname, Lastname, MobileNo, Dateofbirth, Cardnum, cvv, Nameoncard, Expdate, Promocode, availableLimit, eligibleamount)
VALUES(1, 'Maanoj', 'Padhi', '9337557905', '05-11-192', '123123456456', 123, 'Manoj', '05-11-2025',123456789123, '300000', '30000');


INSERT INTO javadb.promocode_info
(Customerid, Firstname, Lastname, MobileNo, Dateofbirth, Cardnum, cvv, Nameoncard, Expdate, Promocode, availableLimit, eligibleamount)
VALUES(2, 'Maanoj', 'Padhi', '9337557905', '05-11-192', '123123456456', 123, 'Manoj', '05-11-2025',123456789123, '300000', '30000');


INSERT INTO javadb.promocode_info
(Customerid, Firstname, Lastname, MobileNo, Dateofbirth, Cardnum, cvv, Nameoncard, Expdate, Promocode, availableLimit, eligibleamount)
VALUES(3, 'Manavi', 'Padhi', '9937557905', '05-11-1993', '123123456478', 234, 'Manavi', '05-11-2027',123456789124, '500000', '50000');


INSERT INTO javadb.promocode_info
(Customerid, Firstname, Lastname, MobileNo, Dateofbirth, Cardnum, cvv, Nameoncard, Expdate, Promocode, availableLimit, eligibleamount)
VALUES(4, 'Sunanda', 'Pradhan', '9737557905', '05-11-1998', '123123456457', 345, 'Sunanda', '05-11-2026',123456789125, '600000', '60000');


INSERT INTO javadb.promocode_info
(Customerid, Firstname, Lastname, MobileNo, Dateofbirth, Cardnum, cvv, Nameoncard, Expdate, Promocode, availableLimit, eligibleamount)
VALUES(5, 'Ram', 'Panda', '9997557905', '05-11-1998', '123123456457', 567, 'Ram', '05-11-2028',123456789126, '900000', '90000');


////////////////////////////////
Call the procedure:

{ CALL javadb.enquiry_V10001(:client_id_in, :channel_id_in, :promocode_in, ?, ?) }

