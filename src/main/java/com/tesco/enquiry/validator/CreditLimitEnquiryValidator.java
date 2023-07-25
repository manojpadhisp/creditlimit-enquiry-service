/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.validator;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.CreditLmitEnquiryRequestInvalidException;
import com.tesco.enquiry.model.EnquiryRequest;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Component

public class CreditLimitEnquiryValidator {

	/**
	 * @param creditLimitRequest
	 */
	public void validateRequest(EnquiryRequest enquiryRequest) throws CreditLmitEnquiryRequestInvalidException{
		// TODO Auto-generated method stub
		//Validate the request ,if the request is valid nothing return
		//else return user defined Exception
		if(enquiryRequest.getPromocode()== null || enquiryRequest.getPromocode().isEmpty() || enquiryRequest.getPromocode().length()< 11)
		{
			throw new CreditLmitEnquiryRequestInvalidException("eq001","Invalid promocode");
		}
		
		if(enquiryRequest.getClientId() == null || "".equals(enquiryRequest.getClientId()))
		{
			throw new CreditLmitEnquiryRequestInvalidException("eq002","Invalid Client id");
		}
		
		
		
	}

}
