/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.intg.dao;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;

/**
 * @Author Manoj by 17-Jul-2023
 */
public interface ICreditLimitEnquiryDao {
	
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException,SystemException;

}
