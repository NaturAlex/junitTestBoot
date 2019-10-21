package cn.ways.common.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangtengchen
 * @Date: 2019/10/21 15:39
 */
@RestController
public class HelloController {

	@Value("${test.key}")
	private String key;

	@RequestMapping("/hello")
	public String hello(){
		return key;
	}
}
