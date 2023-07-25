/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesco.enquiry.exception.CreditLmitEnquiryRequestInvalidException;
import com.tesco.enquiry.model.EnquiryResponse;

/**
 * @Author Manoj by 17-Jul-2023
 */
@ControllerAdvice
public class CreditLimitEnquiryAdvice {
	
	@ResponseBody
	@ExceptionHandler(value = CreditLmitEnquiryRequestInvalidException.class)
	public EnquiryResponse handleLmitEnquiryRequestInvalidException(
			CreditLmitEnquiryRequestInvalidException exception )
	{
		EnquiryResponse enquiryResponse= new EnquiryResponse();
		enquiryResponse.setRespCode(exception.getRespCode());
		enquiryResponse.setRespMsg(exception.getRespMsg());
		
		
		return enquiryResponse;
	}
	

}
