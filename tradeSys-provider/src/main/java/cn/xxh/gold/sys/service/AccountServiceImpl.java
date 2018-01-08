package cn.xxh.gold.sys.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.dao.AccountDao;
import cn.xxh.gold.sys.dao.AccountFlowDao;
import cn.xxh.gold.sys.dao.WithdrawalformDao;
import cn.xxh.gold.sys.entity.Account;
import cn.xxh.gold.sys.entity.AccountFlow;
import cn.xxh.gold.sys.entity.Withdrawalform;
import cn.xxh.gold.vo.WithdrawalformVo;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	WithdrawalformDao withdrawalformDao;
	@Autowired
	AccountFlowDao accountFlowDao;

	public ResBo unfreeze(WithdrawalformVo withdrawalformVo) {
		return null;

	}

	public Integer AuditPassedAndSuccess(WithdrawalformVo withdrawalformVo) {

		WithdrawalformVo vo = withdrawalformDao
				.findWithdrawalformByUserId(withdrawalformVo.getWithdrawalId());

		Account account = accountDao.findAccountByUserId(withdrawalformVo
				.getUserId());
		// 同意提现
		if (vo.getRechargeStatus() == 10) {
			// 解冻提现金额，支出提现金额
			/* BigDecimal FrozenCapital = account.getFrozenCapital(); */
			Integer count = accountDao.unfreezeExpenditureBalance(vo);
			if (count > 0) {
				// 修改订单：已成功
			
				vo.setUserId(withdrawalformVo.getUserId());
				vo.setSucceedtime(new Date());
				vo.setRechargeStatus(20);
				accountDao.AuditPassedAndSuccess(vo);
				/*// 流水表
				if (AuditPassedCount > 0) {
					AccountFlow accountFlow = new AccountFlow();
					accountFlow.setMoney(vo.getWithdrawdMoneny());
					accountFlow.setAccountBalance(account.getAccountbalance());
					accountFlow.setFrozenCapital(account.getFrozenCapital());
					accountFlow.setType(40);
					accountFlow.setBusinessType(20);
					accountFlow.setBusinessId(vo
							.getWithdrawalId());
					accountFlow.setBusinessDescription("提现");
					accountFlow.setAccountId(account.getAccountId());
					accountFlow.setUserId(account.getUserId());
					Integer countAccountFlow = accountFlowDao
							.addAccountFlow(accountFlow);
					if (countAccountFlow > 0) {

					}else{
						throw new RuntimeException("更新订单失败");
					}*/

				}else{
					throw new RuntimeException("更新流水表失败");
			}

		} else {
			// 解冻提现金额
			Integer count = accountDao.unfreeze(vo);
			if(count>0){
				// 修改订单：已失败
				Withdrawalform withdrawalform = new Withdrawalform();
				withdrawalform.setErrortime(new Date());
				withdrawalform.setRechargeStatus(90);
				withdrawalformDao.updateWithdrawalform(withdrawalform);
			}
			AccountFlow accountFlow = new AccountFlow();
			accountFlow.setMoney(vo.getWithdrawdMoneny());
			accountFlow.setAccountBalance(account.getAccountbalance());
			accountFlow.setFrozenCapital(account.getFrozenCapital());
			accountFlow.setType(40);
			accountFlow.setBusinessType(20);
			accountFlow.setBusinessId(vo
					.getWithdrawalId());
			accountFlow.setBusinessDescription("提现");
			accountFlow.setAccountId(account.getAccountId());
			accountFlow.setUserId(account.getUserId());
			Integer countAccountFlow = accountFlowDao
					.addAccountFlow(accountFlow);
			if (countAccountFlow > 0) {

			}else{
				
			throw new RuntimeException("更新流水表失败");
		}
			

		
}

		/*
		 * ResBo resbo = new ResBo(); Account account = new Account();
		 * account.setUserId(withdrawalformVo.getUserId());
		 * account.setAccountbalance(withdrawalformVo.getWithdrawdMoneny());
		 * accountDao.unfreeze(account);
		 */
		return 1;
	}

}
