package cn.ways.common.service;

import cn.ways.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 17:45
 */
public interface IUserService {

	List<User> findByEmail(String email);

	Page<User> findAll(PageRequest pageRequest);

	User save(User u);

	List<User> batchSave(Iterable<User> users);

	List<User> findByLikeEmail(String email);
}
