package cn.xxh.gold.sys.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xxh.DateUtil;
import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.dao.AccountDao;
import cn.xxh.gold.sys.dao.AccountFlowDao;
import cn.xxh.gold.sys.dao.OrderSteadyprofitDao;
import cn.xxh.gold.sys.dao.PriceDao;
import cn.xxh.gold.sys.dao.ProductProfitandLossDao;
import cn.xxh.gold.sys.entity.Account;
import cn.xxh.gold.sys.entity.AccountFlow;
import cn.xxh.gold.sys.entity.OrderAndProduct;
import cn.xxh.gold.sys.entity.OrderAndProfitStatus;
import cn.xxh.gold.sys.entity.OrderSteadyprofit;
import cn.xxh.gold.sys.entity.ProductProfitandLoss;
import cn.xxh.gold.vo.OrderAndProductVo;
import cn.xxh.gold.vo.OrderProductVo;
import cn.xxh.gold.vo.OrderSteadyprofitVo;
import cn.xxh.gold.vo.PriceVo;
import cn.xxh.gold.vo.TableOrderAndproductAndOrderIdVo;

@Service
public class OrderSteadyprofitServiceImpl implements OrderSteadyprofitService {

	
	
	@Autowired
	OrderSteadyprofitDao orderSteadyprofitDao;
	@Autowired
	ProductProfitandLossDao profitandLossDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	AccountFlowDao accountFlowDao;
	@Autowired 
	PriceDao priceDao;
	
	
	public ResBo Addorder(OrderSteadyprofit orderSteadyprofit) {
		ResBo resBo = new ResBo();

		// 根据产品ID 查询产品表
		ProductProfitandLoss productProfitandLoss = profitandLossDao
				.findProductProfitandLossByProductId(orderSteadyprofit
						.getProductId());
		

		/*** 检查产品状态是否可售 **/
		if (productProfitandLoss.getProductStatus() == 10) {

		} else {
			resBo.setMsg("产品不可售");
			resBo.setSuccess(false);
			return resBo;
		}

		//
		orderSteadyprofit.setOrderPrice(GoldPriceServiceImpl.goldPrice);

		BigDecimal buyweight = orderSteadyprofit.getTotalOrder().divide(
				orderSteadyprofit.getOrderPrice(), 3, RoundingMode.DOWN);
		orderSteadyprofit.setBuyWeight(buyweight);
		
		BigDecimal interestRate = productProfitandLoss.getExpectedAnnualizedInterestRate();
		orderSteadyprofit.setInterestRate(interestRate);
		// 添加下单记录
		Integer addorder = orderSteadyprofitDao.Addorder(orderSteadyprofit);
		if (addorder > 0) {

		} else {
			resBo.setMsg("下单失败");
			resBo.setSuccess(false);
			return resBo;
		}
		// 修改订单状态 已下单
		orderSteadyprofit.setOrderStatus(OrderAndProfitStatus.status_10);
		orderSteadyprofit.setOrderTime(new Date());
		Integer status = orderSteadyprofitDao
				.ModifyOrderStatus(orderSteadyprofit);
		if (status > 0) {
			resBo.setMsg("已下单");
			resBo.setSuccess(true);
			
			 OrderSteadyprofit steadyprofit = orderSteadyprofitDao.findByOrderId(orderSteadyprofit.getOrderId());
			
			  OrderSteadyprofitVo orderSteadyprofitVo = BeanUtil.copy(steadyprofit, OrderSteadyprofitVo.class);
			resBo.setData(orderSteadyprofitVo);
			return resBo;
		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
		}
		return resBo;

	}

	public ResBo Pay(OrderSteadyprofit orderSteadyprofit) {
		Long getOrderId = orderSteadyprofit.getOrderId();
		Long getUserId = orderSteadyprofit.getUserId();
		ResBo resBo = new ResBo();
		// 订单ID
		OrderSteadyprofit steadyprofit = orderSteadyprofitDao
				.findByOrderId(getOrderId);
		// 产品ID
		ProductProfitandLoss productProfitandLoss = profitandLossDao
				.findProductProfitandLossByProductId(steadyprofit
						.getProductId());
		// 用户ID
		Account account = accountDao.findAccountByUserId(steadyprofit
				.getUserId());
		/***鉴权判断**/
		if(!getUserId.equals(steadyprofit.getUserId())){
			resBo.setMsg("越权操作！");
			resBo.setSuccess(false);
			return resBo;
		}
		
		/*** 检查产品状态是否可售 **/
		if (productProfitandLoss.getProductStatus() == 10) {

		} else {
			resBo.setMsg("产品不可售");
			resBo.setSuccess(false);
			return resBo;
		}

		/** 检查订单状态：已下单 **/
		if (steadyprofit.getOrderStatus() == 10) {
			
		} else {
			resBo.setMsg("订单不存在");
			resBo.setSuccess(false);
			return resBo;
		}

		/** 检查账户余额是否充足 **/
		BigDecimal accountbalance = account.getAccountbalance();// 账户余额
		BigDecimal totalOrder = steadyprofit.getTotalOrder(); // 订单总额
		// 账户余额大于订单总额 或者 账户余额等于订单总额
		if (accountbalance.compareTo(totalOrder) == 1
				|| accountbalance.compareTo(totalOrder) == 0) {

		} else {
			resBo.setMsg("账户余额不足");
			resBo.setSuccess(false);
			return resBo;
		}
		
		// 修改订单状态 已支付 支付时间
		steadyprofit.setOrderStatus(OrderAndProfitStatus.status_20);
		steadyprofit.setPaymentTime(new Date());
		Integer status = orderSteadyprofitDao
				.ModifyOrderStatusAndPaymentTime(steadyprofit);
		if (status > 0) {
			
		
			 //产品期限
			  Integer day = productProfitandLoss.getProductDeadline();
			//年利率
			BigDecimal expectedAnnualizedInterestRate = productProfitandLoss.getExpectedAnnualizedInterestRate();
			//天利率
			BigDecimal expectedAnnualizedInterestateDay = expectedAnnualizedInterestRate.divide(new BigDecimal("365"), 4,RoundingMode.DOWN);
			//利息
			BigDecimal interest = expectedAnnualizedInterestateDay.multiply(totalOrder.multiply(expectedAnnualizedInterestateDay).multiply(new BigDecimal(day)));
			
			interest = interest.setScale(2, RoundingMode.DOWN);
			steadyprofit.setProfit(interest);
			// 扣减账户余额
			account.setAccountbalance(accountbalance.subtract(totalOrder));
			// 保存修改
			Integer modifyaccountbalance = accountDao
					.modifyAccountbalance(account);
			// 流水表
			if (modifyaccountbalance > 0) {

			} else {
				resBo.setMsg("更新账户余额失败");
				resBo.setSuccess(false);
				return resBo;
			}
			AccountFlow accountFlow = new AccountFlow();
			accountFlow.setMoney(steadyprofit.getTotalOrder());// 订单总额
			accountFlow.setAccountBalance(account.getAccountbalance());// 账户余额
			accountFlow.setType(20);// 支出
			accountFlow.setBusinessType(40);// 稳盈金
			accountFlow.setBusinessId(steadyprofit.getOrderId());// 业务ID
			accountFlow.setAccountId(account.getAccountId());
			accountFlow.setUserId(steadyprofit.getUserId());// 用户ID
			accountFlow.setBusinessDescription("支付");
			Integer addAccountFlow = accountFlowDao.addAccountFlow(accountFlow);
			if (addAccountFlow > 0) {
				resBo.setMsg("订单支付成功");
				resBo.setSuccess(true);
				resBo.setData(steadyprofit);
				return resBo;
			} else {
				resBo.setMsg("订单支付失败");
				resBo.setSuccess(false);
				return resBo;
			}
		} else {
			resBo.setMsg("系统繁忙");
			resBo.setSuccess(false);
		}
		return resBo;
	}

	public ResBo CancelOrder(OrderSteadyprofit orderSteadyprofit) {

		ResBo resBo = new ResBo();
		// 订单ID查询全部
		OrderSteadyprofit steadyprofit = orderSteadyprofitDao
				.findByOrderId(orderSteadyprofit.getOrderId());
		/*** 已下单 */
		if (steadyprofit.getOrderStatus() == 10) {

		} else {
			resBo.setMsg("订单不是已下单");
			resBo.setSuccess(false);
			return resBo;
		}
		steadyprofit.setOrderStatus(50);
		Integer Cancelstatus = orderSteadyprofitDao.CancelOrder(steadyprofit);
		if (Cancelstatus > 0) {
			resBo.setMsg("成功取消订单");
			resBo.setSuccess(true);
			resBo.setData(steadyprofit);
			return resBo;
		} else {
			resBo.setMsg("取消失败");
			resBo.setSuccess(false);
			return resBo;
		}
	}

	public ResBo CarryInterest(OrderSteadyprofit orderSteadyprofit) {
		ResBo resBo = new ResBo();
		// 订单ID 查询全部
		OrderSteadyprofit steadyprofit = orderSteadyprofitDao
				.findByOrderId(orderSteadyprofit.getOrderId());
		// 产品ID 查询全部
		ProductProfitandLoss productProfitandLoss = profitandLossDao
				.findProductProfitandLossByProductId(steadyprofit
						.getProductId());
		if(productProfitandLoss==null){
			resBo.setMsg("未查询相应产品");
			resBo.setSuccess(false);
			return resBo;
		}
		/** 检查订单状态：已支付 **/
		if (steadyprofit.getOrderStatus() == 20) {

		} else {
			resBo.setMsg("订单状态不符");
			resBo.setSuccess(false);
			return resBo;
		}

		// 起息日
		Date beginInterestDate = DateUtil.addDays(steadyprofit.getPaymentTime(), 1);

		// 产品期限
		Integer productDeadline = productProfitandLoss.getProductDeadline();

		// 止息
		Date endInterestDate = DateUtil.addDays(beginInterestDate,
				productDeadline);

		// 回款
		Date datehuikuan = DateUtil.addDays(endInterestDate, 1);

		steadyprofit.setOrderStatus(OrderAndProfitStatus.status_30);
		steadyprofit.setInterestTime(beginInterestDate);
		steadyprofit.setCeaseDay(endInterestDate);
		steadyprofit.setCashBackDay(datehuikuan);
		Integer carryInterest = orderSteadyprofitDao
				.CarryInterest(steadyprofit);
		if (carryInterest > 0) {
			resBo.setMsg("已起息");
			resBo.setSuccess(true);
			resBo.setData(steadyprofit);
			return resBo;
		} else {
			resBo.setMsg("起息失败");
			resBo.setSuccess(false);

		}
		return resBo;
	}

	public ResBo Payment(OrderSteadyprofit orderSteadyprofit) {
		ResBo resBo = new ResBo();
		// 订单ID 查询全部
		OrderSteadyprofit steadyprofit = orderSteadyprofitDao
				.findByOrderId(orderSteadyprofit.getOrderId());
		ProductProfitandLoss productProfitandLoss = profitandLossDao
				.findProductProfitandLossByProductId(steadyprofit.productId);
		Account account = accountDao.findAccountByUserId(steadyprofit
				.getUserId());
		/*** 检查订单状态：已起息 **/
		if (steadyprofit.getOrderStatus() == 30) {

		} else {
			resBo.setMsg("订单状态不符");
			resBo.setSuccess(false);
			return resBo;
		}

		/** 检查当前日期是否等于回款日 ***/
		Date date = new Date();// 2017-11-02 23:27:00.999 2017-11-02
								// 00:00:00.000
		Date cashbackDay = steadyprofit.getCashBackDay();
		Integer rs = DateUtil.compare(date, cashbackDay, "yyyy-MM-dd");
		if (rs == 0) {

		} else {
			resBo.setMsg("当前日期不是回款日");
			resBo.setSuccess(false);
			return resBo;
		}
		BigDecimal totalorder = steadyprofit.getTotalOrder(); // 订单总额
		Integer productDeadline = productProfitandLoss.getProductDeadline();// 产品期限
		BigDecimal expectedAnnualizedInterestRate = productProfitandLoss
				.getExpectedAnnualizedInterestRate();// 年利率

		BigDecimal expectedannualizedInterestrateDay = expectedAnnualizedInterestRate
				.divide(new BigDecimal("365"), 4, RoundingMode.DOWN);

		BigDecimal interest = totalorder.multiply(
				expectedannualizedInterestrateDay).multiply(
				new BigDecimal(productDeadline));
		interest = interest.setScale(2, RoundingMode.DOWN);

		BigDecimal accountbalance = account.getAccountbalance();

		account.setAccountbalance(interest.add(accountbalance));
		Integer count = accountDao.modifyAccountbalance(account);// TODO
		if (count > 0) {
			
		} else {
			throw new RuntimeException("账户余额更新失败");
		}

		accountbalance = account.getAccountbalance();
		account.setAccountbalance(totalorder.add(accountbalance));
		Integer modifyAccountbalance = accountDao.modifyAccountbalance(account);

		if (modifyAccountbalance > 0) {

		} else {
			throw new RuntimeException("账户余额更新失败");
		}

		steadyprofit.setOrderStatus(OrderAndProfitStatus.status_40);
		Integer status = orderSteadyprofitDao.PaymentlOrder(steadyprofit);
																				
		if (status > 0) {
			
		} else {
			throw new RuntimeException("更新订单状态失败");
		}
		/***流水表***/
		AccountFlow accountFlow = new AccountFlow();
		accountFlow.setMoney(steadyprofit.getTotalOrder());
		accountFlow.setAccountBalance(account.getAccountbalance());
		accountFlow.setType(10);
		accountFlow.setBusinessType(40);
		accountFlow.setBusinessId(steadyprofit.getOrderId());
		accountFlow.setAccountId(account.getAccountId());
		accountFlow.setUserId(account.getUserId());
		accountFlow.setBusinessDescription("回款");
		 Integer countflow = accountFlowDao.addAccountFlow(accountFlow);
		 if(countflow>0){
			 resBo.setMsg("订单已回款");
			 resBo.setData(steadyprofit);
			resBo.setSuccess(true);
			return resBo;
		 }else {
				throw new RuntimeException("更新流水表失败");
		 }
		
	}

	public ResBo Overtime(OrderSteadyprofit orderSteadyprofit) {
		ResBo resBo = new ResBo();
		OrderSteadyprofit orderSteady = orderSteadyprofitDao
				.findByOrderId(orderSteadyprofit.getOrderId());
		/**** 订单状态：已下单 ***/
		if (orderSteady.getOrderStatus() == 10) {

		} else {
			resBo.setMsg("订单状态不是已下单");
			resBo.setSuccess(false);
			return resBo;
		}

		Date date = new Date();
		long time = date.getTime();
		if (time - orderSteady.getOrderTime().getTime() > 3600 * 100) {

		} else {
			resBo.setMsg("订单未到超时时间");
			resBo.setSuccess(false);
			return resBo;
		}
		orderSteady.setOrderStatus(OrderAndProfitStatus.status_60);
		Integer count = orderSteadyprofitDao.Overtime(orderSteady);
		if (count > 0) {
			resBo.setMsg("订单已超时");
			resBo.setSuccess(true);
			resBo.setData(orderSteady);
		} else {
			resBo.setMsg("系统繁忙");
			resBo.setSuccess(false);
		}
		return resBo;
	}

	public OrderSteadyprofit findByOrderId(Long OrderId) {
		return orderSteadyprofitDao.findByOrderId(OrderId);
	}

	public List<OrderSteadyprofit> findNoPayOrders() {
		return orderSteadyprofitDao.findNoPayOrders();
	}

	public Page findByPage(Page page) {
		Long totalCount = orderSteadyprofitDao.findByPageCount(page);
		List<OrderSteadyprofitVo> lst = new ArrayList<>();
		if (totalCount > 0) {
			List<OrderSteadyprofit> tmpLst = orderSteadyprofitDao
					.findByPage(page);
			for (OrderSteadyprofit po : tmpLst) {
				lst.add(BeanUtil.copy(po, OrderSteadyprofitVo.class));
			}
		}
		page.setDatas(lst);
		page.setTotalElements(totalCount);

		return page;
	}

	public ResBo findOrderAndPrductprofitUserId(Long userId) {

		List<OrderAndProductVo> list = orderSteadyprofitDao
				.findOrderAndPrductprofitUserId(userId);
		ResBo resbo = new ResBo();
		for (OrderAndProductVo ls : list) {

			Integer orderstatus = ls.getOrderStatus();
			// '状态:10已下单,20已支付,30已起息,40已回款,50已取消,60已超时',

			switch (orderstatus) {
			case 10:
				ls.setOrderStatusStr("已下单");
				break;
			case 20:
				ls.setOrderStatusStr("已支付");
				break;
			case 30:
				ls.setOrderStatusStr("已起息");
				break;
			case 40:
				ls.setOrderStatusStr("已回款");
				break;
			case 50:
				ls.setOrderStatusStr("已取消");
				break;
			case 60:
				ls.setOrderStatusStr("已超时");
				break;
			default:
				throw new RuntimeException("系统繁忙");
			}

		}
		resbo.setData(list);

		return resbo;
	}

	public ResBo OrderAndProductprofitUserIdAndOrderId(Long userId,
			Long orderId) {
		OrderProductVo productVo = orderSteadyprofitDao
				.OrderAndProductprofitUserIdAndOrderId(userId, orderId);
		ResBo resBo = new ResBo();
		Integer status = productVo.getOrderStatus();
		// `orderStatus` int(255) DEFAULT NULL COMMENT
		// '状态:10已下单,20已支付,30已起息,40已回款,50已取消,60已超时',
		if (status == 10) {
			productVo.setOrderStatusStr("已下单");
		} else if (status == 20) {
			productVo.setOrderStatusStr("已支付");
		} else if (status == 30) {
			productVo.setOrderStatusStr("已起息");
		} else if (status == 40) {
			productVo.setOrderStatusStr("已回款");
		} else if (status == 50) {
			productVo.setOrderStatusStr("已取消");
		} else if (status == 60) {
			productVo.setOrderStatusStr("已超时");
		} else {
			throw new RuntimeException("系统繁忙");
		}
		resBo.setData(productVo);
		return resBo;
	}

	public List<OrderSteadyprofit> findCarryInterestOrders() {
		return orderSteadyprofitDao.findCarryInterestOrders();
	}

	public List<OrderSteadyprofit> findPaymentOrders() {
		return orderSteadyprofitDao.findPaymentOrders();
	}
	
	public ResBo tableOrderAndproductAndOrderId(Long orderId){
		ResBo bo = new ResBo();
		TableOrderAndproductAndOrderIdVo tableOrderAndproductAndOrderIdVo = orderSteadyprofitDao.tableOrderAndproductAndOrderId(orderId); 
		bo.setData(tableOrderAndproductAndOrderIdVo);
		return bo;
	}
	
	



}
