package cn.xxh.gold.sys.api;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.vo.OrderSteadyprofitVo;


public interface OrderSteadyprofitApi {

	/**
	 * 添加下单
	 */
	public ResBo Addorder(OrderSteadyprofitVo orderSteadyprofitVo);

	/**
	 * 支付
	 * 
	 * @param orderSteadyprofit
	 * @return
	 */
//	public ResBo Pay(OrderSteadyprofitVo orderSteadyprofitVo);
	
	/**
	 * 分页查询订单
	 * @param queryPage
	 * @return
	 */
	public Page findByPage(Page queryPage) ;
	

}
