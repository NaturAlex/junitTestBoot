package cn.ways.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 13:26
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/info")
	public Map info(){
		Map<String, String> map = new HashMap<>();
		map.put("hello","world");
		return map;
	}
}
