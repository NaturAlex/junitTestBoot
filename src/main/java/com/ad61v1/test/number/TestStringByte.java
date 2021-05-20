package com.ad61v1.test.number;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: eaazhel
 * @Date: 2021/2/2 16:29
 */
public class TestStringByte {

	public static void main(String[] args) throws Exception {
//		String a= "ksl123收到";
//		byte[] bytes = a.getBytes("UTF-8");
//		System.out.println("bytes.length = " + bytes.length);
//		for (byte aByte : bytes) {
//			System.out.println("aByte = " + aByte);
//		}
		byte[] bytes1 = new byte[11];
		FileInputStream fi = new FileInputStream(new File("C:\\Users\\eaazhel\\Desktop\\git_project\\junitTestBoot\\src\\main\\resources\\1.log"));
		int len = 0;
		String s = "";
		while ((len=fi.read(bytes1))!=-1){
			System.out.println("len = " + len);
			String str = new String(bytes1,0,len);
			System.out.println("str = " + str);
			s += str;
		}
		System.out.println("s = " + s);
	}
}
