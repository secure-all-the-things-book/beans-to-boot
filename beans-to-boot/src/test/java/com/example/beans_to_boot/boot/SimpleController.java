package com.example.beans_to_boot.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ResponseBody
@Controller
class SimpleController {

	@GetMapping("/greetings")
	Map<String, String> greetings(@RequestParam String name) {
		return Map.of("greeting", "Hello, " + name + "!");
	}

}