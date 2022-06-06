package com.capgemini.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	static final Logger log = LoggerFactory
			.getLogger(CalculatorController.class);

	@PostMapping("/add")
	public Integer add(@RequestParam(value = "num1") Integer num1,
			@RequestParam(value = "num2") Integer num2) {

		log.info("num1 is " + num1);
		log.info("num2 is " + num2);
		return num1 + num2;

	}

	@PostMapping("/substract")
	public Integer substract(@RequestParam(value = "num1") Integer num1,
			@RequestParam(value = "num2") Integer num2) {

		log.info("num1 is " + num1);
		log.info("num2 is " + num2);
		return num1 - num2;

	}

	@PostMapping("/multiply")
	public Integer multiply(@RequestParam Integer num1,
			@RequestParam Integer num2) {

		log.info("num1 is " + num1);
		log.info("num2 is " + num2);
		return num1 * num2;

	}

	@PostMapping("/divide")
	public Integer divide(Integer num1, Integer num2) {

		log.info("num1 is " + num1);
		log.info("num2 is " + num2);
		return num1 / num2;

	}

}
