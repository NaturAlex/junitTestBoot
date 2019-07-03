package com.ad61v1.test.clone;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author: zhangtengchen
 * @Date: 2019/7/3 15:27
 */
@Data
public class Student implements Cloneable{
	private int age;

	private String name;

	private Teacher teacher;

	private List<Teacher> teachers = new ArrayList<Teacher>();

	private Long id;

	public static void main(String[] args) throws CloneNotSupportedException {
		Student s1 = new Student();
		s1.setAge(10);
		s1.setId(1L);
		s1.setName("s1");
		Teacher t = new Teacher();
		t.setTeacherName("t1");
		Teacher t2 = new Teacher();
		t2.setTeacherName("t2");
		s1.getTeachers().add(t);
		s1.setTeacher(t);
		Student s2 = (Student) s1.clone();
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		s1.setAge(11);
		s1.setName("s11");
		s1.getTeachers().add(t2);
		s1.setId(2L);
		t.setTeacherName("t11");
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
	}

	@Override
	public Object clone() {
		Object obj=null;
		//调用Object类的clone方法，返回一个Object实例
		try {
			obj= super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		//深拷贝
//		Student student = (Student) obj;
//		student.teacher = (Teacher) student.getTeacher().clone();
//		student.teachers = (ArrayList)((ArrayList) (student.getTeachers())).clone();
		//深拷贝

		return obj;
	}
}
