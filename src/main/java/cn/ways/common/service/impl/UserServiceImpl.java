package cn.ways.common.service.impl;

import cn.ways.common.dao.UserRepo;
import cn.ways.common.entity.User;
import cn.ways.common.service.IUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 17:45
 */
@Log4j
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> findByEmail(String email) {
		List<User> us = userRepo.findByEmail(email);
		return us;
	}

	@Override
	public Page<User> findAll(PageRequest pageRequest) {
		Page<User> all = userRepo.findAll(pageRequest);
		return all;
	}

	@Override
	public User save(User u) {
		u = userRepo.save(u);
		log.info("u = " + u);
		return u;
	}

	@Override
	public List<User> batchSave(Iterable<User> users) {
		List<User> us = userRepo.save(users);
		log.info("us = " + us);
		return us;
	}

	@Override
	public List<User> findByLikeEmail(String email) {
		List<User> byEmail = userRepo.findByEmailContaining(email);
		return byEmail;
	}
}
