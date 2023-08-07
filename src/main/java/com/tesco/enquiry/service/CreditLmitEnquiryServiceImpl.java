/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.intg.dao.ICreditLimitEnquiryDao;
import com.tesco.enquiry.model.CustomerInfo;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;
import com.tesco.enquiry.model.EnquiryRequest;
import com.tesco.enquiry.model.EnquiryResponse;
import com.tesco.enquiry.model.StatusBlock;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Component
public class CreditLmitEnquiryServiceImpl implements ICreditLmitEnquiryService {
	
	@Autowired 
	ICreditLimitEnquiryDao creditLimitDao;

	@Override
	public EnquiryResponse enquiry(EnquiryRequest creditLimitRequest) throws BusinessException,SystemException{
		// TODO Auto-generated method stub
		System.out.println("Enter into service");
		//1. Get the reuest from controller
		
		//2. Prpare the request for integration layer
		
		
		//3. call the integation layer and get the resposne.
		
		
		
		EnquiryDaoRequest enquiryDaoRequest= new EnquiryDaoRequest();
		
		enquiryDaoRequest.setClientId(creditLimitRequest.getClientId());
		enquiryDaoRequest.setChannelId(creditLimitRequest.getChannelId());
		enquiryDaoRequest.setPromoCode(creditLimitRequest.getPromocode());
		
		
		EnquiryDaoResponse daoResp=creditLimitDao.enquiry(enquiryDaoRequest);
		
		
		//4 prepare the service resposne
		EnquiryResponse enquiryResponse = new EnquiryResponse();
		
		StatusBlock statusBlock= new StatusBlock();		
		
		statusBlock.setRespCode(daoResp.getRespCode());
		statusBlock.setRespMsg(daoResp.getRespMsg());		
		enquiryResponse.setStatusBlock(statusBlock);
		
		CustomerInfo customerInfo = new CustomerInfo();		
		
		customerInfo.setAvailableAmount(daoResp.getAvailableAmount());
		customerInfo.setCardNum(daoResp.getCardNum());
		customerInfo.setCvv(daoResp.getCvv());
		customerInfo.setIncreaseAmount(daoResp.getIncreaseAmont());
		customerInfo.setIncreasePeer(daoResp.getIncreasePeer());
		
		enquiryResponse.setCustomerInfo(customerInfo);
		
		System.out.println("Exit into service");
		
		return enquiryResponse;
	}
	
	

}
