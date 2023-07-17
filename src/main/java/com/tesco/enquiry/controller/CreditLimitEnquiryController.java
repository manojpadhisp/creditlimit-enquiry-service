/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.enquiry.model.EnquiryRequest;
import com.tesco.enquiry.model.EnquiryResponse;
import com.tesco.enquiry.service.ICreditLmitEnquiryService;
import com.tesco.enquiry.validator.CreditLimitEnquiryValidator;

/**
 * @Author Manoj by 17-Jul-2023
 */
@RestController
@RequestMapping("v1/")
public class CreditLimitEnquiryController 
{
	@Autowired
	CreditLimitEnquiryValidator creditLmitEnquiryValidator;
	
	@Autowired
	ICreditLmitEnquiryService creditLmitService;
	
	@GetMapping("enquiry/{promocode}")
	@ResponseBody
	
	public EnquiryResponse enquiry(@PathVariable("promocode") String promocode,
													  @RequestHeader("client_id") String clientId,
													  @RequestHeader("channel_id") String channelId,
													  @RequestHeader("message_ts") String messageId,
													  @RequestHeader("request_id") String requestid  )
	{
		
		//1. get tge request from consumer/client
		
		EnquiryRequest creditLimitRequest= new EnquiryRequest();
		
		//2. Validate the request
		
		creditLmitEnquiryValidator.validateRequest(creditLimitRequest);
		//3.Prepare the request for service class
		
		//4. Call service class and get the resposne
		EnquiryResponse enquiryResponse = creditLmitService.enquiry(creditLimitRequest);
		return null;
		
	}
	
	
}
