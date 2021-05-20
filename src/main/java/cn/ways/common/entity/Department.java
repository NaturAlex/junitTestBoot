package cn.ways.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author: eaazhel
 * @Date: 2020/9/3 18:25
 */
@Entity
@Table(name = "t_department")
@Getter
@Setter
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dept_name")
	private String deptName;
	@Column(name = "dept_code")
	private String deptCode;
	//测试dept_id更新,user的id会不会更新呢?删除会咋样呢?
	@OneToMany(targetEntity = User.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "dept_id")
	private Set<User> users;

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", deptName='" + deptName + '\'' +
				", deptCode='" + deptCode + '\'' +
				", users=" + users +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Department)) return false;

		Department that = (Department) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
		return deptCode != null ? deptCode.equals(that.deptCode) : that.deptCode == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
		result = 31 * result + (deptCode != null ? deptCode.hashCode() : 0);
		return result;
	}
}
