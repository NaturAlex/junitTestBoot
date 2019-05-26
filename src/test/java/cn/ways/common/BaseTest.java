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

}
