package com.neusoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestAddController {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testAddController_addEmp(){
		try {
			
			mvc.perform(
					MockMvcRequestBuilders.post("/addEmp")
					.param("name", "sky")
					.param("gender", "1")
					.param("birth", "2017-08-18")
					.param("cardnumber", "123456789012345678")
					.param("deptName", "部门")
					.param("postName", "岗位")
					.param("entryDay", "2017-08-18")
					.param("attendDay", "2017-08-18")
					.param("Emform", "100")
					.param("sources", "1")
				).andExpect(MockMvcResultMatchers.status().isOk());  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		
		
	}

	
}
