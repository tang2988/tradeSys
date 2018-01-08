package cn.xxh.gold.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrderProductVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1770855317056073290L;
	
	public String productName;
	public BigDecimal orderPrice;
	public Long orderId;
	public BigDecimal totalOrder;
	public Date orderTime;
	public BigDecimal interestRate;
	public BigDecimal profit;
	public String paymentMethod;
	public String buyWeight;
	public Date paymentTime;
	public Date ceaseDay;
	public Date interestTime;
	public Integer orderStatus;
	public Long userId;
	public Long productId;
	public String orderStatusStr;
	
	
	

	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getOrderStatusStr() {
		return orderStatusStr;
	}


	public void setOrderStatusStr(String orderStatusStr) {
		this.orderStatusStr = orderStatusStr;
	}


	public OrderProductVo() {
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}




	public BigDecimal getOrderPrice() {
		return orderPrice;
	}




	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
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




	public Date getOrderTime() {
		return orderTime;
	}




	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}




	public BigDecimal getInterestRate() {
		return interestRate;
	}




	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}




	public BigDecimal getProfit() {
		return profit;
	}




	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}




	public String getPaymentMethod() {
		return paymentMethod;
	}




	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}




	public String getBuyWeight() {
		return buyWeight;
	}




	public void setBuyWeight(String buyWeight) {
		this.buyWeight = buyWeight;
	}




	public Date getPaymentTime() {
		return paymentTime;
	}




	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}




	public Date getCeaseDay() {
		return ceaseDay;
	}




	public void setCeaseDay(Date ceaseDay) {
		this.ceaseDay = ceaseDay;
	}




	public Date getInterestTime() {
		return interestTime;
	}




	public void setInterestTime(Date interestTime) {
		this.interestTime = interestTime;
	}




	public Integer getOrderStatus() {
		return orderStatus;
	}




	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}




	public Long getUserId() {
		return userId;
	}




	public void setUserId(Long userId) {
		this.userId = userId;
	}




	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
	}
	
}

