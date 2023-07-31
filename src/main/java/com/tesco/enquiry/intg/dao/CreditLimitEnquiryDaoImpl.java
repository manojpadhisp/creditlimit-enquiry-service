/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.intg.dao;

import org.springframework.stereotype.Component;

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

public class CreditLimitEnquiryDaoImpl implements ICreditLimitEnquiryDao{

	@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException,SystemException{
		// TODO Auto-generated method stub
		
		System.out.println("Enter into DAO");
		
		//3 call the database and get the resposne
		EnquiryDaoResponse enquiryDaoResponse;
		try {
			//1 .get the request from service layer
			
			//2 prapre the request fro database
			
			String dbRespCode="0";
			String dbRespMsg="success";
			
			enquiryDaoResponse = new EnquiryDaoResponse();
			
			if(CreditLmitEnquiryConstant.ZERO.equals(dbRespCode))
			{		
				enquiryDaoResponse.setRespCode("0");
				enquiryDaoResponse.setRespMsg("success");
				
				enquiryDaoResponse.setAvailableAmount(1000);
				enquiryDaoResponse.setCardNum("123456789");
				enquiryDaoResponse.setCvv("123");
				enquiryDaoResponse.setIncreaseAmont(50000);
				enquiryDaoResponse.setIncreasePeer(0.5f);
			
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
		
		
		
		//enquiryDaoResponse.setRespCode("0");
		//enquiryDaoResponse.setRespMsg("success");
		
		
		
	
		
		System.out.println("Exit into dao");
		return enquiryDaoResponse;
	}
	


}
