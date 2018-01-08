package cn.xxh.gold.sys.api;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.vo.TopuprechargeVo;

public interface TopuprechargeApi {
	/**
	 * 充值记录
	 * @param topuprecharge
	 * @return
	 */
	public ResBo rechargeRecord(TopuprechargeVo Topuprechargevo);
	
//	public Integer updateStatusAndTime(Topuprecharge topuprecharge);
//	
//	public Integer StatusAndTime(Topuprecharge topuprecharge);

	public Page findTopuprechargePage(Page page);
	
	public Long findCount(Page page);

}
