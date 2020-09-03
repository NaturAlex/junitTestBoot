package cn.ways.common;

import cn.ways.common.dao.UserRepo;
import cn.ways.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 15:49
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@RequestMapping("/add")
	public String add(){
		User u = new User();
		u.setName("abc");
		u.setAddress("GZ");
		userRepo.save(u);
		return "success";
	}

	@RequestMapping("/findAll")
	public Object findAll(){
		List<User> all =
				userRepo.findAll();
		return all;
	}
}
