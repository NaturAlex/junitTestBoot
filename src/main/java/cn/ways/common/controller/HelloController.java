package cn.ways.common.controller;

import cn.ways.common.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangtengchen
 * @Date: 2019/10/21 15:39
 */
@RestController
public class HelloController {
	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Value("${test.key:100}")
	private String key;

	@Autowired
	private AppConfig appConfig;

	@RequestMapping("/hello")
	public String hello(){
		logger.debug(String.format("key:%s",key));
		logger.info(String.format("key:%s",key));
		logger.warn(String.format("key:%s",key));
		logger.error(String.format("key:%s",key));
		appConfig.getKey();
		appConfig.getLoggerLevel();
		return key;
	}
}
