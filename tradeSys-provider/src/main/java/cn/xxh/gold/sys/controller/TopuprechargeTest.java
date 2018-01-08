package cn.xxh.gold.sys.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.dao.AccountDao;
import cn.xxh.gold.sys.dao.TopuprechargeDao;
import cn.xxh.gold.sys.dao.WithdrawalformDao;
import cn.xxh.gold.sys.entity.Account;
import cn.xxh.gold.sys.entity.Topuprecharge;
import cn.xxh.gold.sys.entity.Withdrawalform;
import cn.xxh.gold.sys.service.AccountService;
import cn.xxh.gold.sys.service.TopuprechargeService;
import cn.xxh.gold.sys.service.TopuprechargeServiceImpl;
import cn.xxh.gold.sys.service.WithdrawalformService;
import cn.xxh.gold.sys.service.WithdrawalformServiceImpl;
import cn.xxh.gold.vo.WithdrawalformVo;

@Controller
public class TopuprechargeTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		TopuprechargeService topu = (TopuprechargeService) applicationContext.getBean("topuprechargeServiceImpl");
		WithdrawalformService serviceImpl = (WithdrawalformService) applicationContext.getBean("withdrawalformServiceImpl");
		WithdrawalformDao dao = (WithdrawalformDao) applicationContext.getBean("withdrawalformDao");
		TopuprechargeDao aaa = (TopuprechargeDao) applicationContext.getBean("topuprechargeDao");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		AccountService	accountService = (AccountService) applicationContext.getBean("accountServiceImpl");
		
		Withdrawalform withdrawalform = new Withdrawalform();
		withdrawalform.setRechargeStatus(10);
		withdrawalform.setWithdrawdMoneny(new BigDecimal(300));
		withdrawalform.setApplyfortime(new Date());
		withdrawalform.setUserId(1L);
		 ResBo ab = serviceImpl.addwithdrawalform(withdrawalform);
		System.out.println(ab);
		/*withdrawalform.s
		 Object aa = dao.AuditPassed(withdrawalform);
		 System.out.println(ab);*/
		/*withdrawalform.setUserId(1L);
		withdrawalform.setWithdrawdMoneny(new BigDecimal(100));
		Integer aa = accountDao.unfreeze((withdrawalformVo);
		 System.out.println(aa);*/
		 /*Account aa = accountDao.findAccountByUserId(1L);
		System.out.println(aa);*/
		
	/*	WithdrawalformVo withdrawalformVo = new WithdrawalformVo();
		withdrawalformVo.setWithdrawdMoneny(new BigDecimal(100));
		withdrawalformVo.setWithdrawalId(131L);
		withdrawalformVo.setUserId(1L);
		 Integer aa = accountService.AuditPassedAndSuccess(withdrawalformVo );
		System.out.println(aa);*/
		
	}

}
