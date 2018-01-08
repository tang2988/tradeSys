package cn.xxh.gold.sys.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sun.mail.util.BEncoderStream;

import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.Withdrawalform;
import cn.xxh.gold.sys.service.WithdrawalformService;
import cn.xxh.gold.vo.WithdrawalformVo;

@Component
public class WithdrawalformApiImpl implements WithdrawalformApi{

	@Resource
	WithdrawalformService withdrawalformServiceImpl;
	
	public ResBo addwithdrawalform(WithdrawalformVo withdrawalformVo) {
		Withdrawalform withdrawalform = BeanUtil.copy(withdrawalformVo, Withdrawalform.class);
		return withdrawalformServiceImpl.addwithdrawalform(withdrawalform);
	}

	public Page findTopuprechargePage(Page page) {
		return withdrawalformServiceImpl.findTopuprechargePage(page);
	}

	public Long findCount(Page page) {
		return withdrawalformServiceImpl.findCount(page);
	}
	

}
