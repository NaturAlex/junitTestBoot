package cn.ways.common.dao;

import cn.ways.common.BaseTest;
import cn.ways.common.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 13:57
 */
public class UserRepoTest extends BaseTest {

	@Autowired
	private UserRepo userRepo;

	@Test
	public void insertTest() throws Exception {
		User u = new User();
		u.setId(1L);
		u.setName("abc");
		u.setAddress("GZ");
		userRepo.save(u);
		Thread.sleep(100000);
	}
}