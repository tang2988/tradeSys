package cn.xxh.gold.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrderAndProduct{
	
	public Long orderId;
	public Date orderTime;
	public String productName;
	public BigDecimal expectedAnnualizedInterestRate;
	public BigDecimal profit;
	public String buyWeight;

	public OrderAndProduct() {
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

	

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	

	public String getBuyWeight() {
		return buyWeight;
	}

	public void setBuyWeight(String buyWeight) {
		this.buyWeight = buyWeight;
	}

	public String toString(){
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
		
		
	}
	
	

}
