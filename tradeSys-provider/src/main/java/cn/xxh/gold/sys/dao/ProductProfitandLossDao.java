package cn.xxh.gold.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.entity.ProductProfitandLoss;

@Repository
public interface ProductProfitandLossDao {
	
	public ProductProfitandLoss findProductProfitandLossByProductId(Long productId);
	
	public Integer ModifyProductData(ProductProfitandLoss loss);
	
	public Integer deleteProductProfitandLoss(Long ProfitandId);
	
	public Integer addProductProfitandLoss(ProductProfitandLoss loss);

	public List<ProductProfitandLoss> findByStatus();
	
	public List<ProductProfitandLoss> findByPage(Page page);
	
	public List<ProductProfitandLoss> findByPageAndhsdgold(Page page);
	
	public Long findCount();

}
