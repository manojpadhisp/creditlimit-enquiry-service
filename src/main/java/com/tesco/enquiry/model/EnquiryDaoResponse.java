/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.model;

import lombok.Data;

/**
 * @Author Manoj by 17-Jul-2023
 */

@Data
public class EnquiryDaoResponse {
	
	private String respCode;
	private String respMsg;
	
	
	private String cardNum;
	private String cvv;
	private String Expdate;
	private String Nameoncard;
	private long availableAmount;
	private long increaseAmont;
	private float increasePeer;
	
	
	

}
