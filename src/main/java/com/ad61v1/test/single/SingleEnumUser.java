package com.ad61v1.test.single;

/**
 * 枚举单例
 *  直接把SingleEnumUser做成枚举也可以，但是这样能是饿汉式的，这种方式是懒汉式的
 */
public class SingleEnumUser {

	static{
		System.out.println("测试是否饿汉式");
	}

	private SingleEnumUser() {
	}

	private enum EnumUser{
		INSTANCE;

		private SingleEnumUser singleEnumUser;

		EnumUser() {
			System.out.println("这里打印时机说明是懒汉式的");
			singleEnumUser = new SingleEnumUser();
		}

		private SingleEnumUser getInstance(){
			return singleEnumUser;
		}

	}

	public static SingleEnumUser getInstance(){
		return EnumUser.INSTANCE.getInstance();
	}

	public static void main(String[] args) {
		SingleEnumUser a = new SingleEnumUser();
		System.out.println("a = " + a);
		SingleEnumUser b = SingleEnumUser.getInstance();
		System.out.println("b = " + b);
	}


}
