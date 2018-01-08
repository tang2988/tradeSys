package cn.xxh.gold.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Withdrawalform {
	
	public Long withdrawalId;
	public Integer rechargeStatus;
	public BigDecimal withdrawdMoneny;
	public Date applyfortime;
	public Date succeedtime;
	public Date errortime;
	public Long UserId;
	public Withdrawalform() {
	}
	public Long getWithdrawalId() {
		return withdrawalId;
	}
	public void setWithdrawalId(Long withdrawalId) {
		this.withdrawalId = withdrawalId;
	}
	public Integer getRechargeStatus() {
		return rechargeStatus;
	}
	public void setRechargeStatus(Integer rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}
	public BigDecimal getWithdrawdMoneny() {
		return withdrawdMoneny;
	}
	public void setWithdrawdMoneny(BigDecimal withdrawdMoneny) {
		this.withdrawdMoneny = withdrawdMoneny;
	}
	public Date getApplyfortime() {
		return applyfortime;
	}
	public void setApplyfortime(Date applyfortime) {
		this.applyfortime = applyfortime;
	}
	public Date getSucceedtime() {
		return succeedtime;
	}
	public void setSucceedtime(Date succeedtime) {
		this.succeedtime = succeedtime;
	}
	public Date getErrortime() {
		return errortime;
	}
	public void setErrortime(Date errortime) {
		this.errortime = errortime;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		this.UserId = userId;
	}

	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
	}
	
	
	
	
	

	
	
}
