/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.util;

import lombok.Getter;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Getter
public enum CreditLmitEnquiryErrorEnum {
	
	error_100("100","Promo code is expired","data-error"),
	error_101("101","Promo code is already used","data-error"),
	error_102("102","Promo code is not active","data-error"),
	error_103("103","Promo code is invalid","data-error"),
	
	error_111("111","Database down","data-error"),
	error_222("222","Sql Suntax error","data-error");
	
	
	private String errorCode;
	private String errorMsg;
	private String errorType;
	
	CreditLmitEnquiryErrorEnum(String errorCode,String errorMsg,String errorType)
	{
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
		this.errorType=errorType;
	}
	
	public static boolean checkErrorCode(String errorCode,String errorType)
	{
		
		boolean flag=false;
		for(CreditLmitEnquiryErrorEnum creditEnum: CreditLmitEnquiryErrorEnum.values())
		{
			if(errorCode.equals(creditEnum.getErrorCode()) && errorType.equals(creditEnum.getErrorType()))
			{
				flag=true;	
			}
			else
			{
			
				flag=false;
			}		
		
	  }
		return flag;
	}
	
}
