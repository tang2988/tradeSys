package cn.xxh.gold.sys.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.dao.OrderSteadyprofitDao;
import cn.xxh.gold.sys.dao.ProductProfitandLossDao;
import cn.xxh.gold.sys.entity.OrderAndProduct;
import cn.xxh.gold.sys.entity.OrderSteadyprofit;
import cn.xxh.gold.sys.entity.ProductProfitandLoss;
import cn.xxh.gold.sys.service.AccountService;
import cn.xxh.gold.sys.service.OrderSteadyprofitService;
import cn.xxh.gold.sys.service.OrderSteadyprofitServiceImpl;
import cn.xxh.gold.vo.OrderAndProductVo;
import cn.xxh.gold.vo.OrderProductVo;

@Controller
public class OrderSteadTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		OrderSteadyprofitService service = (OrderSteadyprofitService) context
				.getBean("orderSteadyprofitServiceImpl");
		OrderSteadyprofitDao orderdao = (OrderSteadyprofitDao) context
				.getBean("orderSteadyprofitDao");
		ProductProfitandLossDao lossDao = (ProductProfitandLossDao) context
				.getBean("productProfitandLossDao");
		OrderSteadyprofit orderSteadyprofit = new OrderSteadyprofit();
		
		// orderSteadyprofit.setProductId(2L);
		// orderSteadyprofit.setOrderTime(new Date());
		// orderSteadyprofit.setOrderPrice(new BigDecimal(100));
		// orderSteadyprofit.setTotalOrder(new BigDecimal(100));
		// orderSteadyprofit.setBuyWeight("3");
		// orderSteadyprofit.setInterestRate(new BigDecimal(6.8));
		// orderSteadyprofit.setProfit(new BigDecimal(120));
		// orderSteadyprofit.setUserId(1L);
		// ResBo aa = dao.Addorder(orderSteadyprofit);
		// System.out.println(aa);

		// orderSteadyprofit.setOrderId(21L);
		// ResBo aa = dao.Pay(orderSteadyprofit);
		// System.out.println(aa);

		// orderSteadyprofit.setOrderId(13L);
		// ResBo aa = dao.CancelOrder(orderSteadyprofit);
		// System.out.println(aa);

		// orderSteadyprofit.setOrderId(17L);
		// ResBo aaaa = dao.CarryInterest(orderSteadyprofit);
		// System.out.println(aaaa);

		//
		// Date date = new Date();
		// String dateone = new SimpleDateFormat("yyyy-MM-dd").format(date);
		// System.out.println(dateone);

		// orderSteadyprofit.setOrderId(18L);
		// ResBo aa = dao.Overtime(orderSteadyprofit);
		// System.out.println(aa);

		/*
		 * Page page = new Page(); page.setOffset(2L); page.setPagesize(3);
		 */
		// OrderProductVo aa =
		// orderdao.OrderAndProductprofitUserIdAndOrderId(1L,55L);
		// System.out.println(aa);

		/*
		 * List<OrderSteadyprofit> aa = orderdao.findByPage(page);
		 * System.out.println(aa);
		 */
		
	/*	 orderSteadyprofit.setOrderId(91L);
		  ResBo aba = service.CarryInterest(orderSteadyprofit);
		 System.out.println(aba);
		  ResBo aa = service.Payment(orderSteadyprofit);
		  orderSteadyprofit.setOrderId(16L);
		System.out.println(aa);*/
		
	/*	orderSteadyprofit.setUserId(1L);
		orderSteadyprofit.setTotalOrder(new BigDecimal(100));
		orderSteadyprofit.setProductId(7L);
		ResBo aa = service.Addorder(orderSteadyprofit);
		System.out.println(aa);*/
	/*	orderSteadyprofit.setOrderId(91L);
		  ResBo aab = service.Payment(orderSteadyprofit);
		 System.out.println(aab);*/
		
		
		
	
	}

}
