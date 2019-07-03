package com.ad61v1.test.clone;

import lombok.Data;
/**
 * @Author: zhangtengchen
 * @Date: 2019/7/3 15:27
 */
@Data
public class Teacher implements Cloneable{
	private String teacherName;

	@Override
	public Object clone() {
		Object obj=null;
		//调用Object类的clone方法，返回一个Object实例
		try {
			obj= super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}


}
