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
import cn.xxh.gold.sys.dao.TopuprechargeDao;
import cn.xxh.gold.sys.entity.Account;
import cn.xxh.gold.sys.entity.AccountFlow;
import cn.xxh.gold.sys.entity.Topuprecharge;
import cn.xxh.gold.vo.OrderSteadyprofitVo;
import cn.xxh.gold.vo.TopuprechargeVo;

@Service
public class TopuprechargeServiceImpl implements TopuprechargeService{

	@Autowired
	AccountDao accountDao;
	@Autowired
	TopuprechargeDao topuprechargeDao;
	@Autowired
	AccountFlowDao accountFlowDao;
	public ResBo rechargeRecord(Topuprecharge topuprecharge) {
		
		ResBo resBo = new ResBo();
		//保存充值的记录
		 Integer chargeBean = topuprechargeDao.rechargeRecord(topuprecharge);
		if(chargeBean>0){
		
			
		}else{
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
		//获取用户的数据
		Account account = accountDao.findAccountByUserId(topuprecharge.getUserId()); // 根据用户ID查询 
		//获取当前余额
		 BigDecimal accountbalance = account.getAccountbalance();
		 //充值余额
		BigDecimal recharmoney = topuprecharge.getRecharmoney();
		//赋值余额
		account.setAccountbalance(accountbalance.add(recharmoney));
		//保存修改
		Integer count = accountDao.modifyAccountbalance(account);
		if(count>0){
			
		}else{
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
		AccountFlow  accountFlow = new AccountFlow();
		accountFlow.setMoney(topuprecharge.getRecharmoney());//充值金额
		accountFlow.setAccountBalance(account.getAccountbalance());//账户余额
		accountFlow.setType(10);//收入
		accountFlow.setBusinessType(10);//充值
		accountFlow.setBusinessId(topuprecharge.getRechargeId());//业务ID
		accountFlow.setAccountId(account.getAccountId());
		accountFlow.setUserId(topuprecharge.getUserId());//用户ID
		Integer addAccountFlow = accountFlowDao.addAccountFlow(accountFlow);
		if(addAccountFlow>0){
			topuprecharge.setSucceedTime(new Date());
			topuprecharge.setRechargeStatus(20);
			topuprecharge.setRechargeId(topuprecharge.getRechargeId());
			topuprechargeDao.StatusAndTime(topuprecharge);
			resBo.setSuccess(true);
			resBo.setMsg("充值金额成功"); //成功提示
			return resBo;
		}else{
			topuprecharge.setErrorTime(new Date());
			topuprecharge.setRechargeStatus(90);
			topuprecharge.setRechargeId(topuprecharge.getRechargeId());
			topuprechargeDao.updateStatusAndTime(topuprecharge);
			resBo.setMsg("充值失败");
		}
		return resBo;
	}
	public Page findTopuprechargePage(Page page) {
		Long count = topuprechargeDao.findCount(page);
		 List<TopuprechargeVo> list  = new ArrayList<>();
		if(count>0){
			 List<Topuprecharge> tlist = topuprechargeDao.findTopuprechargePage(page);
			 for(Topuprecharge ab:tlist){
				 list.add(BeanUtil.copy(ab, TopuprechargeVo.class));
			 }
		}
		page.setDatas(list);
		page.setTotalElements(count);
		return page;
	}
	public Long findCount(Page page) {
		return topuprechargeDao.findCount(page);
	}



}
