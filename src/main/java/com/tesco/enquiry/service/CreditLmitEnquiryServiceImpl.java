/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.enquiry.intg.dao.ICreditLimitEnquiryDao;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;
import com.tesco.enquiry.model.EnquiryRequest;
import com.tesco.enquiry.model.EnquiryResponse;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Component
public class CreditLmitEnquiryServiceImpl implements ICreditLmitEnquiryService {
	
	@Autowired 
	ICreditLimitEnquiryDao creditLimitDao;

	@Override
	public EnquiryResponse enquiry(EnquiryRequest creditLimitRequest) {
		// TODO Auto-generated method stub
		
		//1. Get the reuest from controller
		
		//2. Prpare the request for integration layer
		
		
		//3. call the integation layer and get the resposne.
		EnquiryDaoRequest enquiryDaoRequest= new EnquiryDaoRequest();
		EnquiryDaoResponse daoResp=creditLimitDao.enquiry(enquiryDaoRequest);
		return null;
	}
	
	

}
