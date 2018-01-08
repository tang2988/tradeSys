package cn.xxh.gold.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProductProfitandLossVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8240451708188107789L;

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
	public BigDecimal expectedAnnualizedInterestRate;
	/**
	 * 活动加息
	 */
	public BigDecimal activityPlusInterest;
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
	public ProductProfitandLossVo() {
	}
	public ProductProfitandLossVo(Long productId, String productName,
			BigDecimal expectedAnnualizedInterestRate,
			BigDecimal activityPlusInterest, Integer productDeadline,
			BigDecimal sumofMoneyPurchaseddecimal, Integer productStatus) {
		this.productId = productId;
		this.productName = productName;
		this.expectedAnnualizedInterestRate = expectedAnnualizedInterestRate;
		this.activityPlusInterest = activityPlusInterest;
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
		return expectedAnnualizedInterestRate;
	}
	public void setExpectedAnnualizedInterestRate(
			BigDecimal expectedAnnualizedInterestRate) {
		this.expectedAnnualizedInterestRate = expectedAnnualizedInterestRate;
	}
	public BigDecimal getActivityPlusInterest() {
		return activityPlusInterest;
	}
	public void setActivityPlusInterest(BigDecimal activityPlusInterest) {
		this.activityPlusInterest = activityPlusInterest;
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
	public String toString(){
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
	

}
