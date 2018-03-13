package com.iotdeveloper.cloudtools.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lwplvx on 2018/3/12.
 */
public class UdpControllerTest {

    private MockMvc mockMvc;// 模拟MVC对象
    @Autowired
    WebApplicationContext wac;// 注入WebApplicationContext

    @Autowired
    MockHttpServletRequest request; // 模拟request


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGet() throws Exception {

        mockMvc.perform(get("/udp",new Object())) //   POST tcp
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("text/plain;charset=UTF-8")) ;

    }

    @Test
    public void testPost() throws Exception{
        mockMvc.perform(post("/udp")) //   GET tcp
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("text/plain;charset=UTF-8")) ;
    }

    @Test
    public void testGetByPort() throws Exception{
        int port=9001;
        mockMvc.perform(get("/udp/"+port)) //   GET udp/port
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("text/plain;charset=UTF-8"));

    }


}