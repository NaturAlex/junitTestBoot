package cn.ways.common.dao;

import cn.ways.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 13:38
 */
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	Optional<User> findById(Long id);

	List<User> findByEmail(String email);

	List<User> findByEmailContaining(String email);
}
