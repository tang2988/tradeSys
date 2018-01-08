package cn.xxh.gold.sys.entity;

import java.math.BigDecimal;

public class ProductProfitandLoss {
	/**
	 * 产品ID
	 */
	public Long productId;
	
	/**
	 * 产品名称
	 */ 
	public String productName;
	/**
	 * 预期年化金息
	 */
	public BigDecimal ExpectedAnnualizedInterestRate;
	/**
	 * 活动加息
	 */
	public BigDecimal ActivityPlusInterest;
	/**
	 * 产品期限
	 */
	public Integer productDeadline;
	/**
	 * 起购金额
	 */
	public BigDecimal sumofMoneyPurchaseddecimal;
	/**
	 * 状态
	 */
	public Integer productStatus;
	public ProductProfitandLoss() {
	}
	public ProductProfitandLoss(Long productId, String productName,
			BigDecimal expectedAnnualizedInterestRate,
			BigDecimal activityPlusInterest, Integer productDeadline,
			BigDecimal sumofMoneyPurchaseddecimal, Integer productStatus) {
		this.productId = productId;
		this.productName = productName;
		ExpectedAnnualizedInterestRate = expectedAnnualizedInterestRate;
		ActivityPlusInterest = activityPlusInterest;
		this.productDeadline = productDeadline;
		this.sumofMoneyPurchaseddecimal = sumofMoneyPurchaseddecimal;
		this.productStatus = productStatus;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getExpectedAnnualizedInterestRate() {
		return ExpectedAnnualizedInterestRate;
	}
	public void setExpectedAnnualizedInterestRate(
			BigDecimal expectedAnnualizedInterestRate) {
		ExpectedAnnualizedInterestRate = expectedAnnualizedInterestRate;
	}
	public BigDecimal getActivityPlusInterest() {
		return ActivityPlusInterest;
	}
	public void setActivityPlusInterest(BigDecimal activityPlusInterest) {
		ActivityPlusInterest = activityPlusInterest;
	}
	public Integer getProductDeadline() {
		return productDeadline;
	}
	public void setProductDeadline(Integer productDeadline) {
		this.productDeadline = productDeadline;
	}
	public BigDecimal getSumofMoneyPurchaseddecimal() {
		return sumofMoneyPurchaseddecimal;
	}
	public void setSumofMoneyPurchaseddecimal(BigDecimal sumofMoneyPurchaseddecimal) {
		this.sumofMoneyPurchaseddecimal = sumofMoneyPurchaseddecimal;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public String toString() {
		return "ProductProfitandLoss [productId=" + productId
				+ ", productName=" + productName
				+ ", ExpectedAnnualizedInterestRate="
				+ ExpectedAnnualizedInterestRate + ", ActivityPlusInterest="
				+ ActivityPlusInterest + ", productDeadline=" + productDeadline
				+ ", sumofMoneyPurchaseddecimal=" + sumofMoneyPurchaseddecimal
				+ ", productStatus=" + productStatus + "]";
	}
	

}
