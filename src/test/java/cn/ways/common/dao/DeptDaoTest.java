package cn.ways.common.dao;

import cn.ways.common.BaseTest;
import cn.ways.common.entity.Department;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 18:32
 */
public class DeptDaoTest extends BaseTest {
	@Autowired
	private DepartmentRepo departmentRepo;

	@Test
	public void saveDeptTest() throws Exception {
		Department department = new Department();
		department.setDeptName("IAM");
		department.setDeptCode("PIC");
		Department save = departmentRepo.save(department);
		System.out.println("save = " + save);
	}

}
