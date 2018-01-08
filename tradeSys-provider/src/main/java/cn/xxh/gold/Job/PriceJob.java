package cn.xxh.gold.Job;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.service.PriceService;


@Component
public class PriceJob {
	
	@Resource
	PriceService priceService;
	
	public void run(){
		ResBo resbo = priceService.findPriceAndPricetime();
		System.out.println(resbo);
	}

}
