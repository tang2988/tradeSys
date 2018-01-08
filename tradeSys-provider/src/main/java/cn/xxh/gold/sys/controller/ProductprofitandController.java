package cn.xxh.gold.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.ProductProfitandLoss;
import cn.xxh.gold.sys.service.ProductProditandService;
import cn.xxh.gold.vo.ProductProfitandLossVo;

@Controller
@RequestMapping("product")
public class ProductprofitandController {
	
	
	@Resource 
	ProductProditandService productProditandServiceImpl;
	
	
	@RequestMapping("findByStatus")
	@ResponseBody
	public ResBo findByStatus(){
		 ResBo bo = productProditandServiceImpl.findByStatus();
		return bo;
		
	}
	@RequestMapping("findById")
	@ResponseBody
	public ResBo findProductProfitandLossByProductId(Long productId){
		ResBo resbo = productProditandServiceImpl.findProductProfitandLossByProductId(productId);
		return resbo;
		
	}
	@RequestMapping("findPage")
	@ResponseBody
	public ResBo findByPageAndhsdgold(Page page){
		  ResBo resbo = productProditandServiceImpl.findByPageAndhsdgold(page);
		return resbo;
		
		
	}
	
	
	
	

}
