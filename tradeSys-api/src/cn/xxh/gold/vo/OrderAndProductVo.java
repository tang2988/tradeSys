package cn.xxh.gold.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrderAndProductVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5892497442678805950L;
	public Long orderId;
	public Date orderTime;
	public String orderTimeStr;
	public String orderStatusStr;
	public String productName;
	public BigDecimal expectedAnnualizedInterestRate;
	public Long userId;
	public BigDecimal profit;
	public Long productId;
	public String buyWeight;
	public Integer orderStatus;

	public OrderAndProductVo() {
	}
	
	




	public String getOrderStatusStr() {
		return orderStatusStr;
	}






	public void setOrderStatusStr(String orderStatusStr) {
		this.orderStatusStr = orderStatusStr;
	}






	public Integer getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getExpectedAnnualizedInterestRate() {
		return expectedAnnualizedInterestRate;
	}

	public void setExpectedAnnualizedInterestRate(
			BigDecimal expectedAnnualizedInterestRate) {
		this.expectedAnnualizedInterestRate = expectedAnnualizedInterestRate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getBuyWeight() {
		return buyWeight;
	}

	public void setBuyWeight(String buyWeight) {
		this.buyWeight = buyWeight;
	}

	
	public String getOrderTimeStr() {
		return orderTimeStr;
	}


	public void setOrderTimeStr(String orderTimeStr) {
		this.orderTimeStr = orderTimeStr;
	}


	public String toString(){
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
		
		
	}
	
	

}
