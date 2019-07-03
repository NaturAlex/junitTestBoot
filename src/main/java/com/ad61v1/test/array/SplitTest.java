package com.ad61v1.test.array;

import java.util.Arrays;
/**
 * @Author: zhangtengchen
 * @Date: 2019/7/3 15:27
 */
public class SplitTest {

	public static void main(String[] args) {
		String str = "a,b,c,,";
		String[] ary = str.split(",");
		System.out.println("ary.length = " + ary.length);
		System.out.println("Arrays.toString(ary) = " + Arrays.toString(ary));

		String str2 = ",,,";
		String[] ary2 = str2.split(",");
		System.out.println("Arrays.toString(ary2) = " + Arrays.toString(ary2));

	}
}
