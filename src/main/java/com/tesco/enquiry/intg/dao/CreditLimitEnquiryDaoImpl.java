/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.intg.dao;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Component
public class CreditLimitEnquiryDaoImpl implements ICreditLimitEnquiryDao{

	@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) {
		// TODO Auto-generated method stub
		
		//1 .get the request from service layer
		
		//2 prapre the request fro database
		
		//3 call the database and get the resposne
		
		return null;
	}
	


}
