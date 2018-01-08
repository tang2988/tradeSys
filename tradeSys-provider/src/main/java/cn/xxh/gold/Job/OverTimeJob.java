package cn.xxh.gold.Job;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.OrderSteadyprofit;
import cn.xxh.gold.sys.service.OrderSteadyprofitService;

@Component
public class OverTimeJob {

	@Resource
	OrderSteadyprofitService orderSteadyprofitService;

	public void run() {
		Ordertime();
		Payment();
		CarryInterest();

	}

	public void Ordertime() {
		long startTime = System.currentTimeMillis();
		System.out.println("====================start OverTimeJob");
		List<OrderSteadyprofit> list = orderSteadyprofitService
				.findNoPayOrders();
		for (OrderSteadyprofit orderSteadyprofit : list) {
			ResBo res = orderSteadyprofitService.Overtime(orderSteadyprofit);
			System.out.println("rs=" + res + "原数据："
					+ orderSteadyprofit.toString());

		}
		long stopTime = System.currentTimeMillis();
		System.out.println("====================stop OverTimeJob==="
				+ (stopTime - startTime) + "ms");
	}

	public void Payment() {
		List<OrderSteadyprofit> Paymentlist = orderSteadyprofitService
				.findPaymentOrders();
		for (OrderSteadyprofit oSteadyprofit : Paymentlist) {
			ResBo res = orderSteadyprofitService.Payment(oSteadyprofit);
			System.out.println(res);
		}

	}

	public void CarryInterest() {
		List<OrderSteadyprofit> list = orderSteadyprofitService
				.findCarryInterestOrders();
		for (OrderSteadyprofit orSteadyprofit : list) {
			ResBo resBo = orderSteadyprofitService.CarryInterest(orSteadyprofit);
			System.out.println(resBo);

		}
	}

}
