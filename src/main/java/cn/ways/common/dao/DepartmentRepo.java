package cn.ways.common.dao;

import cn.ways.common.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 18:28
 */
public interface DepartmentRepo extends JpaRepository<Department,Long> {

	Department save(Department dept);

}
