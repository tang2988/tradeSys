package cn.xxh.gold.vo;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TableOrderAndproductAndOrderIdVo {
	
	public Long orderId;
	public BigDecimal totalOrder;
	public BigDecimal buyWeight;
	public String productName;
	public BigDecimal expectedAnnualizedInterestRate;
	public BigDecimal profit;
	public TableOrderAndproductAndOrderIdVo() {
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(BigDecimal totalOrder) {
		this.totalOrder = totalOrder;
	}
	public BigDecimal getBuyWeight() {
		return buyWeight;
	}
	public void setBuyWeight(BigDecimal buyWeight) {
		this.buyWeight = buyWeight;
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
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
