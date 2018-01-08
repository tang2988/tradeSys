package cn.xxh.gold.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xxh.gold.vo.PriceVo;

@Repository
public interface PriceDao {
	
	public Integer addPrice(PriceVo priceVo);
	public List<PriceVo> findPriceAndPricetime();

}
