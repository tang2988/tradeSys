package cn.xxh.gold.sys.dao;

import org.springframework.stereotype.Repository;

import cn.xxh.gold.sys.entity.AccountFlow;

@Repository
public interface AccountFlowDao {
	
	public Integer addAccountFlow(AccountFlow accountFlow);

}
