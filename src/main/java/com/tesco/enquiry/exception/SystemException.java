/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.exception;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author Manoj by 26-Jul-2023
 */
@Getter
@ToString
public class SystemException extends RuntimeException{

	private String respCode;
	private String respMsg;
	
	public SystemException(String respCode, String respMsg)
	{
	  this.respCode=respCode;
	  this.respMsg=respMsg;
	}

}
