package cn.xxh.gold.sys.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.entity.ProductProfitandLoss;
import cn.xxh.gold.sys.service.ProductProditandService;
import cn.xxh.gold.vo.ProductProfitandLossVo;

@Service
public class ProductProditandApiImpl implements ProductProditandApi {

	@Resource
	ProductProditandService productProditandServiceImpl;
	

	public Long findCount() {
		return productProditandServiceImpl.findCount();
	}

	public Integer addProductProfitandLoss(ProductProfitandLossVo loss) {
		
		ProductProfitandLoss productProfitandLoss = BeanUtil.copy(loss, ProductProfitandLoss.class);
		
		return productProditandServiceImpl.addProductProfitandLoss(productProfitandLoss);
				
			
	}

	public Page Pagefind(Page page) {
		return productProditandServiceImpl.Pagefind(page);
	}

}
