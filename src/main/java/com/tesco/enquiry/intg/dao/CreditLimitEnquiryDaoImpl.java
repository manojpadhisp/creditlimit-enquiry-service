/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.intg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.CallableStatement;
import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;
import com.tesco.enquiry.util.CreditLmitEnquiryConstant;
import com.tesco.enquiry.util.CreditLmitEnquiryErrorEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Component

public class CreditLimitEnquiryDaoImpl /*implements ICreditLimitEnquiryDao */{

	//Comment this one due to JdbcDaoImp will call
	//@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException,SystemException{
		// TODO Auto-generated method stub
		
		System.out.println("Enter into DAO");
		
		//3 call the database and get the resposne
		EnquiryDaoResponse enquiryDaoResponse;
		try {
		
			Class.forName("com.mysql.jdbc.Driver");			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","manoj");
						
			String sql= "CALL javadb.enquiry_V10001(?, ?, ?, ?, ?)";	
			
			CallableStatement cs= (CallableStatement) con.prepareCall(sql);
			
			//Input param
			cs.setString(1, enquiryDaoRequest.getClientId());
			cs.setString(2, enquiryDaoRequest.getChannelId());
			cs.setString(3, enquiryDaoRequest.getPromoCode());
			
			//Setting output param
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);			
			
			
			cs.execute();
			//execeute the storedprocedure
			ResultSet rs= cs.executeQuery();
			
			String dbRespCode=cs.getString(4);
			String dbRespMsg=cs.getString(5);
			
			if(CreditLmitEnquiryConstant.ZERO.equals(dbRespCode))
			{
				enquiryDaoResponse = new EnquiryDaoResponse();
				while(rs.next())
				{
					enquiryDaoResponse.setRespCode(dbRespCode);
					enquiryDaoResponse.setRespMsg(dbRespMsg);
					
					enquiryDaoResponse.setAvailableAmount(Long.valueOf(rs.getString("availableLimit")));
					enquiryDaoResponse.setIncreaseAmont(Long.valueOf(rs.getString("eligibleamount")));
					
					enquiryDaoResponse.setCardNum(rs.getString("Cardnum"));
					enquiryDaoResponse.setCvv(rs.getString("cvv"));
					enquiryDaoResponse.setExpdate(rs.getString("Expdate"));
					enquiryDaoResponse.setNameoncard(rs.getString("Nameoncard"));
					enquiryDaoResponse.setIncreasePeer(0.5f);
				
				}
			}	
			else if(CreditLmitEnquiryErrorEnum.checkErrorCode(dbRespCode,"data error"))
			{
				
				throw new BusinessException(dbRespCode,dbRespMsg);
			}
			else
			{			
				throw new SystemException(dbRespCode,dbRespMsg);
			}
		} catch (BusinessException be) {
			
			throw be;
		}
		catch (SystemException se) {
			
			throw se;
		}
		
		catch (Exception e) {
				e.printStackTrace();
				throw new SystemException("8888","Unknown error from db");
			}
		
		
		//enquiryDaoResponse.setRespCode("0");
		//enquiryDaoResponse.setRespMsg("success");
		
		
		
	
		
		System.out.println("Exit into dao"+ enquiryDaoResponse);
		return enquiryDaoResponse;
	}
	


}
