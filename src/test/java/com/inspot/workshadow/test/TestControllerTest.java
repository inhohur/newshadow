package com.inspot.workshadow.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class TestControllerTest {

	@Autowired
	private WebApplicationContext context;
	@Autowired
	public TestController testController;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.alwaysDo(MockMvcResultHandlers.print())
				.alwaysExpect(status().isOk()).build();
	}
	
	@Test
	public void testTestController() throws Exception {
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/test/1")
				.contentType(MediaType.TEXT_HTML);
        MvcResult result = mockMvc.perform(reqBuilder)
        		.andExpect(status().isOk())
        		.andExpect(model().attributeExists("objname"))
        		.andDo(print())
        		.andReturn();
//        String body = result.getResponse().getContentAsString();
//        System.out.println("BODY : " + body);
//        assertTrue(body.contains("OK"));
	}

}
