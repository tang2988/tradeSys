package cn.xxh.gold.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TopuprechargeVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4007158646318722491L;
	public Long rechargeId;
	public Long UserId;
	public BigDecimal recharmoney;
	public  Date rechargeTime;
	public Integer rechargeStatus;
	public Date succeedTime;
	public Date errorTime;
	public Long banklistId;
	
	
	public Long getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public BigDecimal getRecharmoney() {
		return recharmoney;
	}
	public void setRecharmoney(BigDecimal recharmoney) {
		this.recharmoney = recharmoney;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	public Integer getRechargeStatus() {
		return rechargeStatus;
	}
	public void setRechargeStatus(Integer rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}
	public Date getSucceedTime() {
		return succeedTime;
	}
	public void setSucceedTime(Date succeedTime) {
		this.succeedTime = succeedTime;
	}
	public Date getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}
	
	
	public Long getBanklistId() {
		return banklistId;
	}
	public void setBanklistId(Long banklistId) {
		this.banklistId = banklistId;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	

	

	
	

}
