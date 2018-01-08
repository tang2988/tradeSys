package cn.xxh.gold.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AccountFlow {
	
	public Long flowId;
	
	public BigDecimal money;
	
	public BigDecimal  accountBalance;
	public BigDecimal frozenCapital;
	public Integer type;
	public Integer businessType;
	public Long businessId;
	public String businessDescription;
	public Long accountId;
	public Long userId;
	public String remark;
	public Integer versionNo;
	public Date createTime;
	public AccountFlow() {
	}
	public Long getFlowId() {
		return flowId;
	}
	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public BigDecimal getFrozenCapital() {
		return frozenCapital;
	}
	public void setFrozenCapital(BigDecimal frozenCapital) {
		this.frozenCapital = frozenCapital;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getBusinessType() {
		return businessType;
	}
	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}
	public Long getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}
	public String getBusinessDescription() {
		return businessDescription;
	}
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String toString() {
		return "AccountFlow [flowId=" + flowId + ", money=" + money
				+ ", accountBalance=" + accountBalance + ", frozenCapital="
				+ frozenCapital + ", type=" + type + ", businessType="
				+ businessType + ", businessId=" + businessId
				+ ", businessDescription=" + businessDescription
				+ ", accountId=" + accountId + ", userId=" + userId
				+ ", remark=" + remark + ", versionNo=" + versionNo
				+ ", createTime=" + createTime + "]";
	}
	
	
}
