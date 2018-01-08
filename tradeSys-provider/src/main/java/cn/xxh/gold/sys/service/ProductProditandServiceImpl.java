package cn.xxh.gold.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.dao.ProductProfitandLossDao;
import cn.xxh.gold.sys.entity.ProductProfitandLoss;
import cn.xxh.gold.vo.ProductProfitandLossVo;

@Service
public class ProductProditandServiceImpl implements ProductProditandService {

	@Autowired 
	ProductProfitandLossDao productProfitandLossDao;

	public ResBo findByStatus() {
		ResBo bo = new ResBo();
		List<ProductProfitandLoss> list = productProfitandLossDao.findByStatus();
		bo.setData(list);
		return bo;
	}

	public ResBo findProductProfitandLossByProductId(
			Long productId) {
		ResBo bo = new ResBo();
		 ProductProfitandLoss loss = productProfitandLossDao.findProductProfitandLossByProductId(productId);
		 bo.setData(loss);
		return bo;
	}

	public ResBo findByPage(Page page) {
		 List<ProductProfitandLoss> list = productProfitandLossDao.findByPage(page);
		 ResBo bo = new ResBo();
		 bo.setData(list);
		return bo;
	}

	
	
	
	
	
	
	public ResBo findByPageAndhsdgold(Page page) {
		ResBo resBo = new ResBo();
		 Long count = productProfitandLossDao.findCount();
		 List<ProductProfitandLossVo> list = new ArrayList<>();
		 if(count>0){
			  List<ProductProfitandLoss> losses = productProfitandLossDao.findByPageAndhsdgold(page);
			  for(ProductProfitandLoss productProfitandLoss :losses){
				  list.add(BeanUtil.copy(productProfitandLoss, ProductProfitandLossVo.class));
			  }
		 }
		 page.setDatas(list);
		 page.setTotalElements(count);
		 resBo.setData(page);
		return resBo;
	}

	public Long findCount() {
		return productProfitandLossDao.findCount();
	}
	
	public Page Pagefind(Page page){
		 Long count = productProfitandLossDao.findCount();
		 List<ProductProfitandLossVo> list = new ArrayList<ProductProfitandLossVo>();
		if(count>0){
			 List<ProductProfitandLoss> productProfitandLosses = productProfitandLossDao.findByPageAndhsdgold(page);
			 for(ProductProfitandLoss loss:productProfitandLosses){
				 list.add(BeanUtil.copy(loss, ProductProfitandLossVo.class));
			 }
		}
		page.setDatas(list);
		page.setTotalElements(count);
		return page;
	}

	public Integer addProductProfitandLoss(ProductProfitandLoss loss) {
		return productProfitandLossDao.addProductProfitandLoss(loss);
	}
	
}
