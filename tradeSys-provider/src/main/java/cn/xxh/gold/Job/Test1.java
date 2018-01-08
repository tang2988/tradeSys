package cn.xxh.gold.Job;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		context.start();
		for(String b:context.getBeanDefinitionNames()){
		
			System.out.println(context);
		}
		System.out.println(1323);
	}

}
