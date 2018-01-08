package cn.xxh.gold.sys.service;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.Withdrawalform;

public interface WithdrawalformService {

	/**
	 * 增加提现记录
	 * 
	 * @param withdrawalform
	 * @return
	 */
	public ResBo addwithdrawalform(Withdrawalform withdrawalform);
	
	public Page findTopuprechargePage(Page page);
	
	public Long findCount(Page page);
	
	

	
}
