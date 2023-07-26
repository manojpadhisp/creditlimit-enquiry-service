/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesco.enquiry.exception.CreditLmitEnquiryRequestInvalidException;
import com.tesco.enquiry.model.EnquiryResponse;
import com.tesco.enquiry.model.StatusBlock;

/**
 * @Author Manoj by 17-Jul-2023
 */
@ControllerAdvice
public class CreditLimitEnquiryAdvice {
	
	@ResponseBody
	@ExceptionHandler(value = CreditLmitEnquiryRequestInvalidException.class)
	public ResponseEntity<EnquiryResponse> handleLmitEnquiryRequestInvalidException(
			CreditLmitEnquiryRequestInvalidException exception )
	{
		EnquiryResponse enquiryResponse= new EnquiryResponse();
		
		StatusBlock statusBlock= new StatusBlock();
		
		statusBlock.setRespCode(exception.getRespCode());
		statusBlock.setRespMsg(exception.getRespMsg());
		
		enquiryResponse.setStatusBlock(statusBlock);
		
		//enquiryResponse.setRespCode(exception.getRespCode());
		//enquiryResponse.setRespMsg(exception.getRespMsg());
		
		
		return new ResponseEntity<EnquiryResponse>(enquiryResponse,HttpStatus.BAD_REQUEST);
	}
	

}
