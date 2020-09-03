package cn.ways.common.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 13:32
 */
@Getter
@Setter
@Table(name = "t_user")
@Entity
@ToString
@EqualsAndHashCode
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;



}
