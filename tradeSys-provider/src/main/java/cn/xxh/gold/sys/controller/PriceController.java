package cn.xxh.gold.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.service.PriceService;

@Controller
@RequestMapping("Price")
public class PriceController {
	
	@Resource
	PriceService PriceServiceImpl;
	
	@RequestMapping("findPrice.do")
	@ResponseBody
	public ResBo findPricedo(){
		ResBo resBo = PriceServiceImpl.findPriceAndPricetime();
		return resBo;
	}

}
