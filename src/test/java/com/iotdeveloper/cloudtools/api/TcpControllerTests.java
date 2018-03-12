package com.iotdeveloper.cloudtools.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iotdeveloper.cloudtools.model.Response.SuccessResponse;
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

    String expectedJson;


    @Before
    public void setup() throws JsonProcessingException {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        expectedJson = Obj2Json(new SuccessResponse());
    }

    protected String Obj2Json(Object obj) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    @Test
    public void testPost() throws Exception {

        mockMvc.perform(post("/tcp", new Object())) //   POST tcp
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("text/plain;charset=UTF-8"));

    }

    @Test
    public void testGet() throws Exception {
        MvcResult result = mockMvc.perform(get("/tcp")) //   GET tcp
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("错误，返回值和预期返回值不一致", expectedJson, content);
    }

    @Test
    public void testGetPort() throws Exception {
        mockMvc.perform(get("/tcp/8500")) //   GET tcp
                .andExpect(status().isOk()) //  预期返回状态为200
                .andExpect(content().contentType("text/plain;charset=UTF-8"));

    }
}
