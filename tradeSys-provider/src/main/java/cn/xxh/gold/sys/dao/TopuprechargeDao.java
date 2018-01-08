package cn.xxh.gold.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.entity.Topuprecharge;


@Repository
public interface TopuprechargeDao {
	
	public Integer rechargeRecord(Topuprecharge topuprecharge);
	
	public Integer updateStatusAndTime(Topuprecharge topuprecharge);
	
	public Integer StatusAndTime(Topuprecharge topuprecharge);
	
	
	public List<Topuprecharge> findTopuprechargePage(Page page);
	
	public Long findCount(Page page);


}
