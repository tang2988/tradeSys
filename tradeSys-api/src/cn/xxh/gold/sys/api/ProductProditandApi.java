package cn.xxh.gold.sys.api;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.vo.ProductProfitandLossVo;


public interface ProductProditandApi {

	public Page Pagefind(Page page);

	public Long findCount();
	
	
	public Integer addProductProfitandLoss(ProductProfitandLossVo loss);
	

}
