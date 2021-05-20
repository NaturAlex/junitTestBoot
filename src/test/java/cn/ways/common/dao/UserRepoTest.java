package cn.ways.common.dao;

import cn.ways.common.BaseTest;
import cn.ways.common.entity.Department;
import cn.ways.common.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 13:57
 */
public class UserRepoTest extends BaseTest {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	@Test
	public void insertTest() throws Exception {

		User u = new User();
		u.setId(1L);
		u.setName("abc");
		u.setAddress("GZ");
		userRepo.save(u);
		Thread.sleep(100000);
	}

	@Test
	public void saveUserWithDeptTest() throws Exception {
		Department department = new Department();
		department.setDeptName("IAM");
		department.setDeptCode("PIC");
		Department save = departmentRepo.save(department);
		System.out.println("save = " + save);
		User u = new User();
		u.setName("Rebort");
		u.setAddress("gz");
		u.setDepartment(save);
		User user = userRepo.save(u);
		System.out.println("user = " + user);
	}

	@Test
	public void queryDeptTest() throws Exception {
	 	saveUserWithDeptTest();
		List<Department> all = departmentRepo.findAll();
		System.out.println("all = " + all);
		Set<User> users = all.get(0).getUsers();
		System.out.println("users = " + users);
	}

}