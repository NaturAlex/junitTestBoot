package com.ad61v1.common;

import com.ad61v1.test.App;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zhangtengchen
 * @Date: 2019/10/29 9:57
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class})
public class BaseTest {

}
