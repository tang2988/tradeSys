package cn.xxh.gold.sys.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xxh.gold.sys.dao.AccountDao;
import cn.xxh.gold.sys.dao.OrderSteadyprofitDao;
import cn.xxh.gold.sys.entity.Account;
import cn.xxh.gold.sys.entity.OrderSteadyprofit;


public class xxh {
	
	public static Calendar Calen(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Date aa = calendar.getTime();
		System.out.println(dateFormat.format(aa));
		return calendar;
		
	}
	
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = new Date();
		System.out.println("当前时间"+date);
		
		String dateformat = dateFormat.format(date);
		System.out.println("格式化后"+dateformat);
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		 Date aa = calendar.getTime();
		 System.out.println(dateFormat.format(aa));
		 
		 calendar.add(Calendar.DAY_OF_YEAR, 10);
		 Date aa2 = calendar.getTime();
		System.out.println(dateFormat.format(aa2));
		
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date bb = calendar.getTime();
		System.out.println(dateFormat.format(bb));
		
		 Calendar aaaaa = xxh.Calen();
		
	}

}
