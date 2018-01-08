package cn.xxh.gold.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.OrderAndProduct;
import cn.xxh.gold.sys.entity.OrderSteadyprofit;
import cn.xxh.gold.vo.OrderAndProductVo;
import cn.xxh.gold.vo.OrderProductVo;
import cn.xxh.gold.vo.TableOrderAndproductAndOrderIdVo;

@Repository
public interface OrderSteadyprofitDao {
	/**
	 * 添加下单
	 */
	public Integer Addorder(OrderSteadyprofit orderSteadyprofit);
	/**
	 * 根据订单ID 修改订单状态 已下单
	 */
	public Integer ModifyOrderStatus(OrderSteadyprofit orderSteadyprofit);
	
	/**
	 * 根据订单ID 修改订单状态 已支付 支付时间
	 * @param orderSteadyprofit
	 * @return
	 */
	public Integer ModifyOrderStatusAndPaymentTime(OrderSteadyprofit orderSteadyprofit);

	/**
	 * 根据订单ID查询
	 */
	public OrderSteadyprofit findByOrderId(Long OrderId);
	
	/**
	 * 支付
	 * @param orderSteadyprofit
	 * @return
	 */
	public Integer Pay(OrderSteadyprofit orderSteadyprofit);
	/**
	 * 取消订单
	 * @param orderSteadyprofit
	 * @return
	 */
	public Integer CancelOrder(OrderSteadyprofit orderSteadyprofit);
	/**
	 * 起息
	 * @param orderSteadyprofit
	 * @return
	 */
	public Integer CarryInterest(OrderSteadyprofit orderSteadyprofit);
	
	/**
	 * 回款
	 * @param orderSteadyprofit
	 * @return
	 */
	public Integer Payment(OrderSteadyprofit orderSteadyprofit);
	/**
	 * 超时
	 * @param orderSteadyprofit
	 * @return
	 */
	public Integer Overtime(OrderSteadyprofit orderSteadyprofit);
	
	public List<OrderSteadyprofit> findNoPayOrders();
	
	
	public List<OrderSteadyprofit> findByPage(Page page);
	public Long findByPageCount(Page page);	
	
	
	public List<OrderAndProductVo> findOrderAndPrductprofitUserId(Long userId);
	
	
	public OrderProductVo OrderAndProductprofitUserIdAndOrderId(@Param("userId")Long userId,@Param("orderId")Long orderId);
	
	
	public List<OrderSteadyprofit>findCarryInterestOrders();
	
	
	public List<OrderSteadyprofit>findPaymentOrders();
	/**
	 * 回款状态；
	 * @param orderSteadyprofit
	 * @return
	 */
	public Integer PaymentlOrder(OrderSteadyprofit orderSteadyprofit);
	
	public TableOrderAndproductAndOrderIdVo tableOrderAndproductAndOrderId(Long orderId);

}
