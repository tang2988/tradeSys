package cn.xxh.gold.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.entity.Topuprecharge;
import cn.xxh.gold.sys.entity.Withdrawalform;
import cn.xxh.gold.vo.WithdrawalformVo;

@Repository
public interface WithdrawalformDao {

	public Integer addwithdrawalform(Withdrawalform withdrawalform);

	public Integer updatestatusbysuccesstime(Withdrawalform withdrawalform);

	public Withdrawalform findById(Long withdrawalformId);
	
	public List<Withdrawalform> findTopuprechargePage(Page page);
	
	public Long findCount(Page page);
	
	
	public Integer updateWithdrawalform(Withdrawalform withdrawalform);
	
	
	public Integer AuditPassed(Withdrawalform withdrawalform);
	
	public WithdrawalformVo findWithdrawalformByUserId(Long withdrawalId);




}
