package cn.xxh.gold.sys.service;

import java.util.List;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.OrderSteadyprofit;
import cn.xxh.gold.vo.OrderAndProductVo;
import cn.xxh.gold.vo.OrderProductVo;

public interface OrderSteadyprofitService {
	
	/**
	 * 添加下单
	 */
	public ResBo Addorder(OrderSteadyprofit orderSteadyprofit);
	/**
	 * 支付
	 * @param orderSteadyprofit
	 * @return
	 */
	public ResBo Pay(OrderSteadyprofit orderSteadyprofit);
	/**
	 * 取消订单
	 * @param orderSteadyprofit
	 * @return
	 */
	public ResBo CancelOrder(OrderSteadyprofit orderSteadyprofit);
	/**
	 * 起息
	 * @param orderSteadyprofit
	 * @return
	 */
	public ResBo CarryInterest(OrderSteadyprofit orderSteadyprofit);
	/**
	 * 回款
	 * @param orderSteadyprofit
	 * @return
	 */
	public ResBo Payment(OrderSteadyprofit orderSteadyprofit);

	/**
	 * 超时
	 * @param orderSteadyprofit
	 * @return
	 */
	public ResBo Overtime(OrderSteadyprofit orderSteadyprofit);
	
	public OrderSteadyprofit findByOrderId(Long OrderId);
	
	/**
	 * 查询已下单的订单
	 * @return
	 */
	public List<OrderSteadyprofit> findNoPayOrders();
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	public Page findByPage(Page page) ;
	
	
	public ResBo findOrderAndPrductprofitUserId(Long userId);
	
	
	/**
	 * 查看详情
	 * @param userId
	 * @param orderId
	 * @return
	 */
	public ResBo OrderAndProductprofitUserIdAndOrderId(Long userId,Long orderId);
	
	/**
	 * 查询已支付状态
	 * @return
	 */
	public List<OrderSteadyprofit>findCarryInterestOrders();
	
	/**
	 * 查询已起息状态
	 * @return
	 */
	public List<OrderSteadyprofit> findPaymentOrders();
	


	public ResBo tableOrderAndproductAndOrderId(Long orderId);
	
}

