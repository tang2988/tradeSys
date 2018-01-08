package cn.xxh.gold.sys.api;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.vo.WithdrawalformVo;

public interface WithdrawalformApi {

	/**
	 * 增加提现记录
	 * 
	 * @param withdrawalform
	 * @return
	 */
	public ResBo addwithdrawalform(WithdrawalformVo withdrawalformVo);
	
	public Page findTopuprechargePage(Page page);
	
	public Long findCount(Page page);

	
}
