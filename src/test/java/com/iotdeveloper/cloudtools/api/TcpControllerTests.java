package com.iotdeveloper.cloudtools.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@WebAppConfiguration("src/main/resources")
@SpringBootTest
public class TcpControllerTests {

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
    public void testPost() throws Exception {

        mockMvc.perform(post("/tcp",new Object())) //   POST tcp
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("text/plain;charset=UTF-8")) ;

    }

    @Test
    public void testGet() throws Exception{
        mockMvc.perform(get("/tcp")) //   GET tcp
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("text/plain;charset=UTF-8")) ;
    }

    @Test
    public void testGetPort() throws Exception{
        mockMvc.perform(get("/tcp/8500")) //   GET tcp
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("text/plain;charset=UTF-8"));

    }
}
