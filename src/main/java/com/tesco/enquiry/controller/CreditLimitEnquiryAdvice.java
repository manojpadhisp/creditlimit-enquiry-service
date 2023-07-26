/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.CreditLmitEnquiryRequestInvalidException;
import com.tesco.enquiry.exception.SystemException;
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
		EnquiryResponse enquiryResponse = buildErrorResponse(exception.getRespCode(),exception.getRespMsg());
		
		//enquiryResponse.setRespCode(exception.getRespCode());
		//enquiryResponse.setRespMsg(exception.getRespMsg());
		
		
		return new ResponseEntity<EnquiryResponse>(enquiryResponse,HttpStatus.BAD_REQUEST);
	}
	
	
	//
	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<EnquiryResponse> handleDataError(BusinessException exception)			
	{
		EnquiryResponse enquiryResponse = buildErrorResponse(exception.getRespCode(),exception.getRespMsg());
		
		//enquiryResponse.setRespCode(exception.getRespCode());
		//enquiryResponse.setRespMsg(exception.getRespMsg());
		
		
		return new ResponseEntity<EnquiryResponse>(enquiryResponse,HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(value = SystemException.class)
	public ResponseEntity<EnquiryResponse> handleSystemError(SystemException exception)			
	{
		EnquiryResponse enquiryResponse = buildErrorResponse(exception.getRespCode(),exception.getRespMsg());
		
		//enquiryResponse.setRespCode(exception.getRespCode());
		//enquiryResponse.setRespMsg(exception.getRespMsg());		
		
		return new ResponseEntity<EnquiryResponse>(enquiryResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Generic erro
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<EnquiryResponse> handleGenericErrors(Exception exception)			
	{
		EnquiryResponse enquiryResponse = buildErrorResponse("8888","Unknown error");
		
		//enquiryResponse.setRespCode(exception.getRespCode());
		//enquiryResponse.setRespMsg(exception.getRespMsg());		
		
		return new ResponseEntity<EnquiryResponse>(enquiryResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
		
	private EnquiryResponse buildErrorResponse(String respCode, String respMsg) {
		EnquiryResponse enquiryResponse= new EnquiryResponse();
		
		StatusBlock statusBlock= new StatusBlock();
		
		statusBlock.setRespCode(respCode);
		statusBlock.setRespMsg(respMsg);
		
		enquiryResponse.setStatusBlock(statusBlock);
		return enquiryResponse;
	}
	
	

}
