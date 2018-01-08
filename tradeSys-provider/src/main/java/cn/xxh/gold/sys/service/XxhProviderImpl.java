package cn.xxh.gold.sys.service;

import org.springframework.stereotype.Service;

@Service
public class XxhProviderImpl implements XxhProvider{

	public Integer add(Integer add1, Integer add2) {
		return add1+add2;
	}

}
