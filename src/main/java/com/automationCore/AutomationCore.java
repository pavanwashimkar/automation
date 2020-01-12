package com.automationCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AutomationCore {

	public static void main(String[] args) {
		SpringApplication.run(AutomationCore.class, args);
	}
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/app-context.xml");
}
