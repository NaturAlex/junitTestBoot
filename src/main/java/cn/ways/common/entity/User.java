package cn.ways.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 13:32
 */
@Getter
@Setter
@Table(name = "t_user")
@Entity
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

	@ManyToOne(targetEntity = Department.class,cascade = CascadeType.REFRESH,fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "dept_id")
	private Department department;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				", dept.id=" + department.getId() +
				", dept.name=" + department.getDeptName() +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if (address != null ? !address.equals(user.address) : user.address != null) return false;
		if (email != null ? !email.equals(user.email) : user.email != null) return false;
		return department != null ? department.equals(user.department) : user.department == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (department != null ? department.hashCode() : 0);
		return result;
	}

}
