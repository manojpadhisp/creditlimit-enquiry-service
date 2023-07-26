/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.intg.dao;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Component

public class CreditLimitEnquiryDaoImpl implements ICreditLimitEnquiryDao{

	@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter into DAO");
		
		//1 .get the request from service layer
		
		//2 prapre the request fro database
		
		//3 call the database and get the resposne
		EnquiryDaoResponse enquiryDaoResponse= new EnquiryDaoResponse();
		
		enquiryDaoResponse.setRespCode("0");
		enquiryDaoResponse.setRespMsg("success");
		
		enquiryDaoResponse.setAvailableAmount(1000);
		enquiryDaoResponse.setCardNum("123456789");
		enquiryDaoResponse.setCvv("123");
		enquiryDaoResponse.setIncreaseAmont(50000);
		enquiryDaoResponse.setIncreasePeer(0.5f);
		
		System.out.println("Exit into dao");
		return enquiryDaoResponse;
	}
	


}
