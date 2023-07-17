/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.validator;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.model.EnquiryRequest;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Component

public class CreditLimitEnquiryValidator {

	/**
	 * @param creditLimitRequest
	 */
	public void validateRequest(EnquiryRequest enquiryRequest) {
		// TODO Auto-generated method stub
		//Validate the request ,if the request is valid nothing return
		//else return user defined Exception
		
	}

}
