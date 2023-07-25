/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.model;

import org.springframework.web.bind.annotation.RequestHeader;

import lombok.Data;

/**
 * @Author Manoj by 17-Jul-2023
 */
@Data
public class EnquiryRequest {
     private String promocode;
	 private String clientId;
	 private String channelId;
	 private String messageId;
	 private String requestid;

}
