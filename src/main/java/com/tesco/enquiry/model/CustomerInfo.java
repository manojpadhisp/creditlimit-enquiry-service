/**Bny Mellon Ldt we should not disclose
 * otherwise term and condtions will apply.
 */
package com.tesco.enquiry.model;

import lombok.Data;

/**
 * @Author Manoj by 26-Jul-2023
 */
@Data
public class CustomerInfo {

	private String cardNum;
	private String cvv;
	private long availableAmount;
	private long increaseAmount;
	private float increasePeer;
}
