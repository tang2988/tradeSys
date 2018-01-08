package cn.xxh.gold.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.dao.PriceDao;
import cn.xxh.gold.vo.PriceVo;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PriceDao priceDao;
	public ResBo addPrice(PriceVo priceVo) {
		ResBo resBo = new ResBo();
		Integer count = priceDao.addPrice(priceVo);
		resBo.setData(count);
		return resBo;
	}

	public ResBo findPriceAndPricetime() {
		 ResBo resBo = new ResBo();
		  List<PriceVo> list = priceDao.findPriceAndPricetime();
		 resBo.setData(list);
		return resBo;
	}

}
