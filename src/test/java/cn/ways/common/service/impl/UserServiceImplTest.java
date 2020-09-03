package cn.ways.common.service.impl;

import cn.ways.common.BaseTest;
import cn.ways.common.entity.User;
import cn.ways.common.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 17:56
 */
public class UserServiceImplTest extends BaseTest {
	@Autowired
	private IUserService userService;

	@Test
	public void findByEmail() {
		batchSave();
		List<User> byEmail = userService.findByEmail("tom@qq.com");
		System.out.println("byEmail = " + byEmail);
	}

	@Test
	public void findByEmailLikeTest() throws Exception {
		batchSave();
		List<User> byEmail = userService.findByLikeEmail("qq.com");
		System.out.println("byEmail = " + byEmail);
	}

	@Test
	public void findAll() {
		batchSave();
		PageRequest pr = new PageRequest(0, 1,new Sort(Sort.Direction.DESC,"id"));
		Page<User> all = userService.findAll(pr);
		System.out.println("all = " + all);
		List<User> content = all.getContent();
		System.out.println("content = " + content);
	}

	@Test
	public void save() {
		User user = new User();
		user.setName("mary");
		user.setAddress("mary@qq.com");
		User save = userService.save(user);
		System.out.println("save = " + save);
	}

	@Test
	public void batchSave() {

		User user = new User();
		user.setName("mary");
		user.setAddress("gz");
		user.setEmail("mary@qq.com");
		User user2 = new User();
		user2.setName("tom");
		user2.setEmail("tom@qq.com");
		user2.setAddress("bj");
		List<User> users = Arrays.asList(user, user2);
		List<User> us = userService.batchSave(users);
		System.out.println("us = " + us);
	}


}