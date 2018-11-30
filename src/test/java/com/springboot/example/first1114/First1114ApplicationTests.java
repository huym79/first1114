package com.springboot.example.first1114;

import com.springboot.example.first1114.controller.UserController;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
/**
@RunWith(SpringRunner.class)
@SpringBootTest
public class First1114ApplicationTests {

    @Test
    public void contextLoads() {
    }

}
*/
//引入Spring对JUnit4的支持
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration 该注释在1.4.0版本以前，以后不存在了；用 @SpringBootTest 就可以了
//@SpringApplicationConfiguration(classes = First1114Application.class)
//指定Spring Boot的启动类
@SpringBootTest(classes = First1114Application.class)
//开启Web应用的配置，用于模拟ServletContext
@WebAppConfiguration
public class First1114ApplicationTests {
    //MockMvc对象，用于模拟调用Controller的接口发起请求
    private MockMvc mvc;
    //Junit中定义在测试用例内容执行前预加载的内容，这里用来初始化对UserController的模拟
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
        System.out.println("before");
    }

    @Test
    public void getUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/show?name=test1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("test2")));
        System.out.println("test");
    }

    @After
    public void testAfter() {
        System.out.println("after");
    }

}