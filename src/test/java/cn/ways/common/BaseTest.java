package cn.ways.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhangtengchen on 2019/1/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    @Test
    public void test() {
        System.out.println("true = " + true);
    }

    abstract class Handler{
    	public Handler(){
    		handle();
		}
    	abstract void handle();
	}

    @Test
    public void abTest() throws Exception {
    	int a = 1;
    	int b = 2;
		Handler handler = new Handler() {
			@Override
			void handle() {
				int c = a+b;
				System.out.println("c = " + c);
			}
		};
		System.out.println("a = " + a);
	}

}
