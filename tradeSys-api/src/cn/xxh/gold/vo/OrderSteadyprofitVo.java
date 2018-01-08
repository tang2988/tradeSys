package cn.xxh.gold.vo;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrderSteadyprofitVo implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11941074045474320L;
	
	/**
	 * 订单ID
	 */
	public Long orderId;
	/**
	 * 产品ID
	 */
	public Long productId;
	/**
	 * 用户ID
	 */
	public Long userId;
	/**
	 * 下单时间
	 */

	public Date orderTime;
	/**
	 * 支付时间
	 */
	public Date paymentTime;
	/**
	 * 起息日
	 */
	public Date interestTime;
	/**
	 * 止息日
	 */
	public Date ceaseDay;
	/**
	 * 回款日
	 */
	public Date cashBackDay;
	/**
	 * 支付方式：10余额支付；20网银支付
	 */
	public String paymentMethod;
	/**
	 * 订单金价
	 */
	public BigDecimal orderPrice;
	/**
	 * 订单总额
	 */
	public BigDecimal totalOrder;
	/**
	 * 买入克重
	 */
	public String buyWeight;
	/**
	 * 利率
	 */
	public BigDecimal interestRate;
	/**
	 * 收益
	 */
	public BigDecimal profit;
	/**
	 * 状态
	 */
	public int OrderStatus;
	/**
	 * 备注
	 */
	public String remark;
	/**
	 * 版本号
	 */
	public Integer versionNo;
	/**
	 * 插入时间
	 */
	public Date createTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getInterestTime() {
		return interestTime;
	}

	public void setInterestTime(Date interestTime) {
		this.interestTime = interestTime;
	}

	public Date getCeaseDay() {
		return ceaseDay;
	}

	public void setCeaseDay(Date ceaseDay) {
		this.ceaseDay = ceaseDay;
	}

	public Date getCashBackDay() {
		return cashBackDay;
	}

	public void setCashBackDay(Date cashBackDay) {
		this.cashBackDay = cashBackDay;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public BigDecimal getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(BigDecimal totalOrder) {
		this.totalOrder = totalOrder;
	}

	public String getBuyWeight() {
		return buyWeight;
	}

	public void setBuyWeight(String buyWeight) {
		this.buyWeight = buyWeight;
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

	public int getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		OrderStatus = orderStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
