package cn.xxh.gold.sys.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import cn.xxh.gold.sys.dao.ProductProfitandLossDao;
import cn.xxh.gold.sys.service.ProductProditandService;

@Controller
public class ProductTest {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		ProductProfitandLossDao dao = (ProductProfitandLossDao) applicationContext.getBean("productProfitandLossDao");
		ProductProditandService productProditandService = (ProductProditandService) applicationContext.getBean("productProditandServiceImpl");
		String[] benaneName = applicationContext.getBeanDefinitionNames();
		for(String aaa:benaneName){
			System.out.println(aaa);
		}
		
	
//		ProductProfitandLoss loss = new ProductProfitandLoss();
//		loss.setProductName("理财产品");
//		loss.setExpectedAnnualizedInterestRate(new BigDecimal(6.7));
//		loss.setActivityPlusInterest(new BigDecimal(1.2));
//		loss.setProductDeadline(10);
//		loss.setSumofMoneyPurchaseddecimal(new BigDecimal(100));
//		loss.setProductStatus(10);
//		
//		Integer ceeshi = dao.addProductProfitandLoss(loss );
//		System.out.println(ceeshi);

		//		   Integer aab = dao.deleteProductProfitandLoss(5L);
//		System.out.println(aab);
//		loss.setProductId(2L);
//	    Integer aa = dao.ModifyProductData(loss);
//	System.out.println(aa);
		
		/*Page page = new Page();
		page.setPagesize(3);
		page.setOffset(1L);
		 List<ProductProfitandLoss> aa = dao.findByPageAndhsdgold(page );
		System.out.println(aa);*/
	}
	
}
