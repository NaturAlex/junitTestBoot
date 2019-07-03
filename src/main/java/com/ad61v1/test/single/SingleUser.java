package com.ad61v1.test.single;

/**
 * @Author: zhangtengchen
 * @Date: 2019/7/3 15:27
 * 线程安全的单例
 *	参考：https://www.cnblogs.com/boboshenqi/p/9403627.html
 *  volatie可以防止指令重排
 *  synchronized:
 *  修饰：
 *  this|object，对象锁  只锁当前实例的所在代码块
 *  class,类锁   所有线程
 *  method，方法锁  对象的所在方法
 *  static method，同类锁一样效果  所有线程
 *
 *

 1、对于静态方法，由于此时对象还未生成，所以只能采用类锁；

 2、只要采用类锁，就会拦截所有线程，只能让一个线程访问。

 3、对于对象锁（this），如果是同一个实例，就会按顺序访问，但是如果是不同实例，就可以同时访问。

 4、如果对象锁跟访问的对象没有关系，那么就会都同时访问。
 *
 *
 */
public class SingleUser {

	private SingleUser() {
	}

	private volatile static SingleUser instance;

	public static SingleUser getInstance(){
		if(null == instance){
			synchronized (SingleUser.class){
				if(instance == null){
					instance = new SingleUser();
				}
			}
		}
		return instance;
	}
}
