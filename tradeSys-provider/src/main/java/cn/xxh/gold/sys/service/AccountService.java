package cn.xxh.gold.sys.service;

import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.Account;
import cn.xxh.gold.vo.WithdrawalformVo;

public interface AccountService {
	
	public ResBo unfreeze(WithdrawalformVo withdrawalformVo);
	
	public Integer AuditPassedAndSuccess(WithdrawalformVo withdrawalformVo);

}
