package cn.xxh.gold.sys.api;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.Topuprecharge;
import cn.xxh.gold.sys.service.TopuprechargeService;
import cn.xxh.gold.sys.service.TopuprechargeServiceImpl;
import cn.xxh.gold.vo.TopuprechargeVo;

@Component
public class TopuprechargeApiImpl implements TopuprechargeApi {

	@Resource
	TopuprechargeService topuprechargeServiceImpl;
	public ResBo rechargeRecord(TopuprechargeVo Topuprechargevo) {
		Topuprecharge topuprecharge = BeanUtil.copy(Topuprechargevo, Topuprecharge.class);
		return topuprechargeServiceImpl.rechargeRecord(topuprecharge);
	}

	public Page findTopuprechargePage(Page page) {
		return topuprechargeServiceImpl.findTopuprechargePage(page);
	}

	public Long findCount(Page page) {
		return topuprechargeServiceImpl.findCount(page);
	}
	

}
