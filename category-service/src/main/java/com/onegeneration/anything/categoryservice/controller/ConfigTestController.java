package com.onegeneration.anything.categoryservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onegeneration.anything.categoryservice.config.GlobalConfig;

@RestController
@RefreshScope
public class ConfigTestController {

	@Value("${global.params.p1}")
	private int p1;
	@Value("${global.params.p2}")
	private int p2;
	@Value("${category.params.x}")
	private int i;
	@Value("${category.params.y}")
	private int j;
	@Autowired
	private GlobalConfig globalConfig;

	@GetMapping("testConfig")
	public Map<String, Integer> configTest() {
		return Map.of("p1", p1, "p2", p2, "i", i, "j", j);
	}

	@GetMapping("/globalConfig")
	public GlobalConfig globalConfigTest() {
		return globalConfig;
	}

}
