package com.iotdeveloper.cloudtools.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration("src/main/resources")
@SpringBootTest
public class HomeControllerTests {

    private MockMvc mockMvc;//2 模拟MVC对象
    @Autowired
    WebApplicationContext wac;//4 注入WebApplicationContext
    @Autowired
    MockHttpSession session;//5 注入模拟的http session

    @Autowired
    MockHttpServletRequest request; // 模拟request

    @Before
    public void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @Test
    public void testIndex() throws Exception {

        String uri = "/";

//        MvcResult result=mockMvc.perform(get(uri).a


        MvcResult result = mockMvc.perform(get(uri)) //8 模拟GET /
                .andExpect(status().isOk())//9 预期返回状态为200
                .andExpect(view().name("index"))//10 预期view的名称
//                .andExpect(forwardedUrl("/resources/templates/index.html"))//11 预期页面转向的真正路径
//                .andExpect(model().attribute("message", null))//12 预期model里的值
                .andReturn();

        Object msg=result.getModelAndView().getModel().get("message");
        Assert.assertNotNull(msg);
        Assert.assertTrue(msg.toString().length()>5);

    }

}
