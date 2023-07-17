/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.service;

import com.tesco.enquiry.model.EnquiryRequest;
import com.tesco.enquiry.model.EnquiryResponse;

/**
 * @Author Manoj by 17-Jul-2023
 */
public interface ICreditLmitEnquiryService {

	public EnquiryResponse enquiry(EnquiryRequest creditLimitRequest);
	
}
