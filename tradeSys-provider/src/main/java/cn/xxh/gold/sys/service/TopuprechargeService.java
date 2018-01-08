package cn.xxh.gold.sys.service;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.Topuprecharge;

public interface TopuprechargeService {
	
	/**
	 * 充值记录
	 * @param topuprecharge
	 * @return
	 */
	public ResBo rechargeRecord(Topuprecharge topuprecharge);
	
//	public Integer updateStatusAndTime(Topuprecharge topuprecharge);
//	
//	public Integer StatusAndTime(Topuprecharge topuprecharge);

	public Page findTopuprechargePage(Page page);
	
	public Long findCount(Page page);
}
