package com.ad61v1.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: zhangtengchen
 * @Date: 2019/7/3 15:27
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = {"com.ad61v1","com.i61"})
@ComponentScan(basePackages = {"com.ad61v1","com.i61"})
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
