package cn.xxh.gold.sys.service;

import java.util.List;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.ProductProfitandLoss;

public interface ProductProditandService {
	
	public ResBo findByStatus();
	
	public ResBo findProductProfitandLossByProductId(Long productId);
	
	public Integer addProductProfitandLoss(ProductProfitandLoss loss);
	
	public ResBo findByPage(Page page);
	
	
	public ResBo findByPageAndhsdgold(Page page);
	
	public Page Pagefind(Page page);
	
	public Long findCount();

}
