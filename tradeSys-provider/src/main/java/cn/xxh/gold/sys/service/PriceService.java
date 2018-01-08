package cn.xxh.gold.sys.service;

import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.vo.PriceVo;

public interface PriceService {
	
	public ResBo addPrice(PriceVo priceVo);
	public ResBo findPriceAndPricetime();

}
