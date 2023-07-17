/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.model;

import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @Author Manoj by 17-Jul-2023
 */
public class EnquiryRequest {

	 private String clientId;
	 private String channelId;
	 private String messageId;
	 private String requestid;
	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}
	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}
	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	/**
	 * @return the requestid
	 */
	public String getRequestid() {
		return requestid;
	}
	/**
	 * @param requestid the requestid to set
	 */
	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}
	
	
}
