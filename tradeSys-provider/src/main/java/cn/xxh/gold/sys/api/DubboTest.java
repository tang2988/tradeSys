package cn.xxh.gold.sys.api;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DubboTest {
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		for(String bn :context.getBeanDefinitionNames()){
			System.out.println(bn);
		}
		context.start();
		System.out.println("Dubbo start");
		System.in.read();
	}

}
