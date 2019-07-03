package cn.ways.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * @Author: zhangtengchen
 * @Date: 2019/7/3 15:27
 */
@SpringBootApplication
@ComponentScan({"com.ways","cn.ways"})
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
