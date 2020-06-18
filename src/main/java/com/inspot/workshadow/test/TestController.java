package com.inspot.workshadow.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inspot.workshadow.test.model.TestEntity;
import com.inspot.workshadow.test.model.TestParam;
import com.inspot.workshadow.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testService;
	
	@GetMapping("/add")
	public String addObj() {
		testService.add("addok");
		return "test/addok";
	}
	
	@PutMapping
	public String updateObj(@RequestBody TestParam param) {
		TestEntity test = TestEntity.builder().name("putuser").build();
		testService.add(test);
		return "test/putok";
	}
	
	// 테스트할 때 : http://localhost:8080/workshadow/test/3?name=111
	@GetMapping("{id}")
	public String getOneObj(@PathVariable Long id, TestParam testParam, Model model) {
 		TestEntity test = testService.getOneUser();
		if(test == null) {
			testService.add("therewasnouser");
			test = testService.getOneUser();
		}
		model.addAttribute("name", testParam.getName());
		model.addAttribute("objname", test.getName());
		model.addAttribute("id", id);
		return "test/get";
	}

	@GetMapping
	public String getOneObj(Model model) {
		return "test/addok";
	}
	
}
