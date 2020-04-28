package com.ad61v1.common;

import com.ad61v1.test.App;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: zhangtengchen
 * @Date: 2019/11/1 10:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
@AutoConfigureMockMvc
@Profile("DEV")
@Slf4j
//@ComponentScan(basePackages = {"com.ad61v1","com.i61"})
public class BaseControllerTest {
	@Autowired
	private WebApplicationContext context;

	protected MockMvc mockMvc;
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}


}
