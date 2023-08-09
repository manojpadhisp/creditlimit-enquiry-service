/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.intg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;
import com.tesco.enquiry.util.CreditLmitEnquiryConstant;
import com.tesco.enquiry.util.CreditLmitEnquiryErrorEnum;

/**
 * @Author Manoj by 08-Aug-2023
 */

@Component
public class CreditLimitEnqiryDaoSpringJdbcDaoImpl extends StoredProcedure implements ICreditLimitEnquiryDao,RowMapper<EnquiryDaoResponse>{

	@Autowired
	public CreditLimitEnqiryDaoSpringJdbcDaoImpl(JdbcTemplate jdbctemplate)
	{
		super(jdbctemplate,CreditLmitEnquiryConstant.SP_NAME);
		regesterParam();
	}	

	private void regesterParam() {
		
		declareParameter(new SqlParameter(CreditLmitEnquiryConstant.CLIENT_ID_IN, Types.VARCHAR));
		declareParameter(new SqlParameter(CreditLmitEnquiryConstant.CHANNEL_ID_IN, Types.VARCHAR));
		declareParameter(new SqlParameter(CreditLmitEnquiryConstant.PROMOCODE_IN, Types.VARCHAR));
		
		
		declareParameter(new SqlOutParameter(CreditLmitEnquiryConstant.RESPCODE_OUT, Types.VARCHAR));
		declareParameter(new SqlOutParameter(CreditLmitEnquiryConstant.RESPMSG_OUT, Types.VARCHAR));
		
		//register ResultSet
		
		declareParameter(new SqlReturnResultSet(CreditLmitEnquiryConstant.RESULTSET_NAME, this));
				
		
	}


	@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException, SystemException {
		
		System.out.println("Entered into enquiry Springjdbc");
		EnquiryDaoResponse enquiryDaoResponse = new EnquiryDaoResponse();
		
		//Prepare StoredProcedure Request 		
		Map<String, Object> requestMap= new HashMap<String,Object>();
		
		requestMap.put(CreditLmitEnquiryConstant.CLIENT_ID_IN, enquiryDaoRequest.getClientId());
		requestMap.put(CreditLmitEnquiryConstant.CHANNEL_ID_IN, enquiryDaoRequest.getChannelId());
		requestMap.put(CreditLmitEnquiryConstant.PROMOCODE_IN, enquiryDaoRequest.getPromoCode());
		
		try {	
		
		//execute the sp
		Map<String, Object> respMap = super.execute(requestMap);
		
		//get the outparam
		String dbRespCode = respMap.get(CreditLmitEnquiryConstant.RESPCODE_OUT).toString();
		String dbRespMsg = respMap.get(CreditLmitEnquiryConstant.RESPMSG_OUT).toString();
		
		if( CreditLmitEnquiryConstant.ZERO.equals(dbRespCode) ) {
			
			System.out.println("Entered into inside if condtion Springjdbc"+ enquiryDaoResponse);
			enquiryDaoResponse.setRespCode(dbRespCode);
			enquiryDaoResponse.setRespMsg(dbRespMsg);
			// prepare the dao response with the help of ResultSet
			
			List<EnquiryDaoResponse> daoResp= (List<EnquiryDaoResponse>) respMap.get(CreditLmitEnquiryConstant.RESULTSET_NAME);
			enquiryDaoResponse=daoResp.get(0);
			
		}else if( CreditLmitEnquiryErrorEnum.checkErrorCode(dbRespCode, "data error") ) {
			
			throw new BusinessException(dbRespCode, dbRespMsg);
		}else {
			
			throw new SystemException(dbRespCode, dbRespMsg);
			}
		}
		catch (BusinessException be) {
			
			throw be;
		}
		catch (SystemException se) {
			
			throw se;
		}
		
		catch (Exception e) {
				e.printStackTrace();
				throw new SystemException("8888","Unknown error from db");
			}
		
		System.out.println("Entered into enquiry Springjdbc"+ enquiryDaoResponse);
		return enquiryDaoResponse;
		
	}

	@Override
	public EnquiryDaoResponse  mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		System.out.println("Entered into mapRow");
		
		EnquiryDaoResponse enquiryDaoResponse = new EnquiryDaoResponse();
	
		enquiryDaoResponse.setAvailableAmount(Long.valueOf(rs.getString("availableLimit")));
		enquiryDaoResponse.setIncreaseAmont(Long.valueOf(rs.getString("eligibleamount")));
		enquiryDaoResponse.setCardNum(rs.getString("Cardnum"));
		enquiryDaoResponse.setCvv(rs.getString("cvv"));
		enquiryDaoResponse.setExpdate(rs.getString("Expdate"));
		enquiryDaoResponse.setNameoncard(rs.getString("Nameoncard"));
		enquiryDaoResponse.setIncreasePeer(0.5f);
		
		System.out.println("Exit from mapRow"+ enquiryDaoResponse);
		return enquiryDaoResponse;
	}
	
	

}
