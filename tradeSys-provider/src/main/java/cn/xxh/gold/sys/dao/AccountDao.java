package cn.xxh.gold.sys.dao;

import org.springframework.stereotype.Repository;

import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.Account;
import cn.xxh.gold.sys.entity.Withdrawalform;
import cn.xxh.gold.vo.WithdrawalformVo;


@Repository
public interface AccountDao {

	
	
	public Account findAccountByUserId(Long userId);
	
	public Integer modifyAccountbalance(Account account);
	
	public Integer modifyAccountbalanceAndFrozenCapital(Account account);
	
	public Integer unfreeze(WithdrawalformVo withdrawalformVo);
	
	public Integer AuditPassedAndSuccess(WithdrawalformVo withdrawalformVo);
	
	public Integer unfreezeExpenditureBalance(WithdrawalformVo withdrawalformVo);

}
