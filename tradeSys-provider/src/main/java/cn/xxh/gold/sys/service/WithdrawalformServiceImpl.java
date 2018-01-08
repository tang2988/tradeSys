 package cn.xxh.gold.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.dao.AccountDao;
import cn.xxh.gold.sys.dao.AccountFlowDao;
import cn.xxh.gold.sys.dao.UserDao;
import cn.xxh.gold.sys.dao.WithdrawalformDao;
import cn.xxh.gold.sys.entity.Account;
import cn.xxh.gold.sys.entity.AccountFlow;
import cn.xxh.gold.sys.entity.Withdrawalform;
import cn.xxh.gold.vo.WithdrawalformVo;

@Service
public class WithdrawalformServiceImpl implements WithdrawalformService {

	@Autowired 
	AccountDao accountDao;
	@Autowired 
	WithdrawalformDao withdrawalformDao;
	@Autowired 
	AccountFlowDao  accountFlowDao;
	
	public ResBo addwithdrawalform(Withdrawalform withdrawalform) {
		ResBo resBo = new ResBo(); // 实例化

		Account account = accountDao.findAccountByUserId(withdrawalform.getUserId());// 根据用户ID
		BigDecimal accountbalance = account.getAccountbalance(); // 获取当前余额
		BigDecimal withdrawdMoneny = withdrawalform.getWithdrawdMoneny(); // 获取提现余额
		BigDecimal frozenCapital = account.getFrozenCapital(); //冻结余额
		
		
		
		
		
		if (accountbalance.compareTo(withdrawdMoneny) >=0) {

		} else {
			resBo.setMsg("提现金额大于当前余额");
			resBo.setSuccess(false);
			return resBo;
		}
		
		Integer count = withdrawalformDao.addwithdrawalform(withdrawalform);
		if (count>0) {
			
		}else{
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
		account.setAccountbalance(accountbalance.subtract(withdrawdMoneny)); // 当前余额-提现余额
		account.setFrozenCapital(frozenCapital.add(withdrawdMoneny));
		Integer modify = accountDao.modifyAccountbalanceAndFrozenCapital(account);
		
		if (modify>0) {
			
		} else {
			resBo.setMsg("申请失败");
			resBo.setSuccess(false);
		}
		AccountFlow accountFlow = new AccountFlow();
		accountFlow.setMoney(withdrawdMoneny);
		accountFlow.setAccountBalance(accountbalance);
		accountFlow.setFrozenCapital(frozenCapital);
		accountFlow.setType(20);
		accountFlow.setBusinessType(20);
		accountFlow.setBusinessId(withdrawalform.getWithdrawalId());
		accountFlow.setBusinessDescription("提现");
		accountFlow.setAccountId(account.getAccountId());
		accountFlow.setUserId(account.getUserId());
		Integer countAccountFlow = accountFlowDao.addAccountFlow(accountFlow);
		if(countAccountFlow>0){
			resBo.setSuccess(true);
			resBo.setMsg("申请成功");
			return resBo;
		}else{
			withdrawalform.setErrortime(new Date());
			withdrawalform.setRechargeStatus(90);
			withdrawalformDao.updateWithdrawalform(withdrawalform);
		}
		
		return resBo;
	}

	public Page findTopuprechargePage(Page page) {
		 Long count = withdrawalformDao.findCount(page);
		 List<WithdrawalformVo> list = new ArrayList<>();
		 if(count>0){
			 List<Withdrawalform> wilist = withdrawalformDao.findTopuprechargePage(page);
			 for(Withdrawalform list1:wilist){
				 list.add(BeanUtil.copy(list1, WithdrawalformVo.class));
			 }
			 
		 }
		 page.setDatas(list);
		 page.setTotalElements(count);
		return page;
	}

	public Long findCount(Page page) {
		return withdrawalformDao.findCount(page);
	}
	
	public ResBo AuditPassed(Withdrawalform withdrawalform){
		Account account = accountDao.findAccountByUserId(withdrawalform.getUserId());
		
		
		/***账户状态10正常-20禁用'**/
		if(account.getAccountStatus()==10){
			
		}
		//账户余额
		BigDecimal accountbalance = account.getAccountbalance();
		BigDecimal frozenCapital = account.getFrozenCapital();//冻结资金
		
		return null;	
		
	}
	
	


}
