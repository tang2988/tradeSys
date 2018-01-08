/*
 * Copyright (C) 2015 ShenZhen HeShiDai Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package cn.xxh.gold.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xxh.decrypt.MD5;
import cn.xxh.gold.common.utils.BeanUtil;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.entity.OrderAndProduct;
import cn.xxh.gold.sys.entity.OrderSteadyprofit;
import cn.xxh.gold.sys.service.OrderSteadyprofitService;
import cn.xxh.gold.vo.OrderAndProductVo;
import cn.xxh.gold.vo.OrderProductVo;
import cn.xxh.gold.vo.OrderSteadyprofitVo;

/**
 * 类功能介绍
 * 
 * @version 2016年3月11日下午5:12:29
 * @author du.dxlove
 */
@Controller
@RequestMapping("OrderSteadyprofitApi")
public class OrderSteadyprofitController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	String md5_salt = "123456";
	
	@Resource
	OrderSteadyprofitService orderSteadyprofitServiceImpl;

	@RequestMapping("addorder")
	// OrderSteadyprofitApi/addorder?productId=2&userId=1&totalOrder=10
	@ResponseBody
	public ResBo addorder(OrderSteadyprofitVo orderSteadyprofitVo, String md5Signture ) {
		TreeMap<String, String> signMap = new TreeMap<>();
		signMap.put("productId", orderSteadyprofitVo.getProductId()+"");
		signMap.put("userId", orderSteadyprofitVo.getUserId()+"");
		signMap.put("totalOrder", orderSteadyprofitVo.getTotalOrder()+"");
		String signStr =signMap.toString()+md5_salt;
		System.out.println(signStr);
		String md5Str = MD5.generateMD5(signStr);
		
		if(!md5Str.equalsIgnoreCase(md5Signture)){
			ResBo resVo  = new ResBo();
			resVo.setSuccess(false);
			resVo.setMsg("请求非法");
			return resVo;
		}
		
		ResBo resVo = orderSteadyprofitServiceImpl.Addorder(BeanUtil.copy(orderSteadyprofitVo, OrderSteadyprofit.class));
		System.out.println(resVo);
		
		return resVo;
	}
	
	@RequestMapping("Pay")
	@ResponseBody
	public ResBo Pay(OrderSteadyprofitVo orderSteadyprofitvo,String md5Signture){
		TreeMap<String, String> tree = new TreeMap<String, String>();
		tree.put("orderId", orderSteadyprofitvo.getOrderId()+"");
		tree.put("userId", orderSteadyprofitvo.getUserId()+"");
		String str = tree.toString()+md5_salt;
		String generateMD5 = MD5.generateMD5(str);
		if(!generateMD5.equalsIgnoreCase(md5Signture)){
			ResBo resVo  = new ResBo();
			resVo.setSuccess(false);
			resVo.setMsg("请求非法");
			return resVo;
		}
		ResBo pay = orderSteadyprofitServiceImpl.Pay(BeanUtil.copy(orderSteadyprofitvo, OrderSteadyprofit.class));
		System.out.println(pay);
		return pay;
	}
	@RequestMapping("CancelOrder")
	@ResponseBody
	public ResBo CancelOrder(OrderSteadyprofitVo orderSteadyprofitvo,String md5Signture){
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("orderId", orderSteadyprofitvo.getOrderId()+"");
		String str = treeMap.toString()+md5_salt;
		String generateMD5 = MD5.generateMD5(str);
		if(!generateMD5.equalsIgnoreCase(md5Signture)){
			ResBo resVo  = new ResBo();
			resVo.setSuccess(false);
			resVo.setMsg("请求非法");
			return resVo;
		}

		ResBo cancelOrder = orderSteadyprofitServiceImpl.CancelOrder(BeanUtil.copy(orderSteadyprofitvo, OrderSteadyprofit.class));
		return cancelOrder;
		
	}
	@RequestMapping("CarryInterest")
	@ResponseBody
	public ResBo CarryInterest(OrderSteadyprofitVo orderSteadyprofitvo){
		/*TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("orderId", orderSteadyprofitvo.getOrderId()+"");
		String string = treeMap.toString();
		 String generateMD5 = MD5.generateMD5(string);
		if(!generateMD5.equalsIgnoreCase(md5Signture)){
			ResBo resVo  = new ResBo();
			resVo.setSuccess(false);
			resVo.setMsg("请求非法");
			return resVo;
		}*/
		
		ResBo carryInterest = orderSteadyprofitServiceImpl.CarryInterest(BeanUtil.copy(orderSteadyprofitvo, OrderSteadyprofit.class));
		return carryInterest;
	}
	@RequestMapping("Payment")
	@ResponseBody
	public ResBo Payment(OrderSteadyprofitVo orderSteadyprofitVo){
		ResBo payment = orderSteadyprofitServiceImpl.Payment(BeanUtil.copy(orderSteadyprofitVo, OrderSteadyprofit.class));
		return payment;
	}
	@RequestMapping("Overtime")
	@ResponseBody
	public ResBo Overtime(OrderSteadyprofitVo orderSteadyprofitvo){
	
		ResBo overtime = orderSteadyprofitServiceImpl.Overtime(BeanUtil.copy(orderSteadyprofitvo, OrderSteadyprofit.class));
		return overtime;
		
	}
	
	@RequestMapping("findById")
	@ResponseBody
	public OrderSteadyprofitVo findByOrderId(Long orderId,String md5_salt) {
		OrderSteadyprofit orderSteadyprofit =  orderSteadyprofitServiceImpl.findByOrderId(orderId);
		OrderSteadyprofitVo vo = BeanUtil.copy(orderSteadyprofit, OrderSteadyprofitVo.class);
		return vo;
	}
	
	@RequestMapping("findOrderAndPrduct")
	@ResponseBody
	public ResBo findOrderAndPrductprofitUserId(Long userId,String md5Signture){
		TreeMap<String, String> tree = new TreeMap<String, String>();
		tree.put("userId", userId+"");
		 String str = tree.toString()+md5_salt;
		 String generateMD5 = MD5.generateMD5(str);
		 if(!generateMD5.equalsIgnoreCase(md5Signture)){
			 ResBo resVo  = new ResBo();
				resVo.setSuccess(false);
				resVo.setMsg("请求非法");
				return resVo;
		 }
		    ResBo resBo = orderSteadyprofitServiceImpl.findOrderAndPrductprofitUserId(userId);
		 return resBo;
	}
	
	@RequestMapping("TheOrderDetails")
	@ResponseBody
	public ResBo OrderAndProductprofitUserIdAndOrderId(Long userId,Long orderId,String md5Signture){
		TreeMap<String, String> map  = new TreeMap<String, String>();
		map.put("userId", userId+"");
		map.put("orderId", orderId+"");
		 String md5salt = map.toString()+md5_salt;
		 String generateMD5 = MD5.generateMD5(md5salt);
		 if(!generateMD5.equalsIgnoreCase(md5Signture)){
			 ResBo bo = new ResBo();
			 bo.setMsg("请求非法");
			 bo.setSuccess(false);
			 return bo;
		 }
		ResBo resbo = orderSteadyprofitServiceImpl.OrderAndProductprofitUserIdAndOrderId(userId, orderId);
		System.out.println(resbo);
		return resbo;
		
	}
	@RequestMapping("TableOrderAndproductAndOrderId.do")
	@ResponseBody
	public ResBo tableOrderAndproductAndOrderIdDo(Long orderId,String md5_salt){
		ResBo resBo = orderSteadyprofitServiceImpl.tableOrderAndproductAndOrderId(orderId);
		return resBo;
	}
	

	
}
