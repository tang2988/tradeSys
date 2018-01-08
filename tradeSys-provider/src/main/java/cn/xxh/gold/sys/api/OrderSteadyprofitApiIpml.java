package cn.xxh.gold.sys.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.OrderSteadyprofit;
import cn.xxh.gold.sys.service.OrderSteadyprofitService;
import cn.xxh.gold.vo.OrderSteadyprofitVo;

@Component
public class OrderSteadyprofitApiIpml implements OrderSteadyprofitApi{

	@Resource
	OrderSteadyprofitService orderSteadyprofitServiceImpl;
	
	/**
	 * 添加下单
	 */
	public ResBo Addorder(OrderSteadyprofitVo orderSteadyprofitVo){
		OrderSteadyprofit orderSteadyprofit = BeanUtil.copy(orderSteadyprofitVo, OrderSteadyprofit.class);
		return orderSteadyprofitServiceImpl.Addorder(orderSteadyprofit);
	}

	/**
	 * 支付
	 * 
	 * @param orderSteadyprofit
	 * @return
	 */
//	public ResBo Pay(OrderSteadyprofitVo orderSteadyprofitVo){
//		OrderSteadyprofit orderSteadyprofit = BeanUtil.copy(orderSteadyprofitVo, OrderSteadyprofit.class);
//		return orderSteadyprofitServiceImpl.Pay(orderSteadyprofit);
//	}

 
	public Page findByPage(Page queryPage) {
		return orderSteadyprofitServiceImpl.findByPage(queryPage);
	}
	
	
}
