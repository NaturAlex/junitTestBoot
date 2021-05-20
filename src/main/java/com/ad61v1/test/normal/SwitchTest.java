package com.ad61v1.test.normal;

/**
 * @Author: eaazhel
 * @Date: 1/4/2021 5:05 PM
 */
public class SwitchTest {

	public static void main(String[] args) {
		String a = "A";
		switch (a){
			case "A":
				System.out.println("A");
			case "123":
				System.out.println("123");
			case "456":
				System.out.println("456");
				break;
			default:
				System.out.println("default");
		}

	}
}
