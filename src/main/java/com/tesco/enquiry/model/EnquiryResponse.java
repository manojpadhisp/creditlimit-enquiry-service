/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Data
@JsonInclude(value = Include.NON_NULL)
public class EnquiryResponse {
	
	private StatusBlock statusBlock;
	private CustomerInfo customerInfo;
	
	/*
	private String respCode;
	private String respMsg;*/
	
	/*
	private String cardNum;
	private String cvv;
	private long availableAmount;
	private long increaseAmount;
	private float increasePeer;*/
	

}
