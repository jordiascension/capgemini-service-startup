package com.capgemini.demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.demo.model.PensionPlan;

@RequestMapping("pension-plan")
@RestController
public class PensionPlanController {

	@PostMapping("/deduct")
	@CrossOrigin
	public ResponseEntity<Double> deduct(
			@Valid @RequestBody PensionPlan pensionPlan) {
		double deduction = 0;
		double totalPensionPlan = pensionPlan.getCompanyPensionPlan()
				+ pensionPlan.getPersonPensionPlan();

		if (pensionPlan.getTaxbase() >= 12450
				&& pensionPlan.getTaxbase() < 20200) {
			deduction = totalPensionPlan * 24 / 100;
		} else if (pensionPlan.getTaxbase() >= 20200
				&& pensionPlan.getTaxbase() < 35200) {
			deduction = totalPensionPlan * 30 / 100;
		} else if (pensionPlan.getTaxbase() >= 35200
				&& pensionPlan.getTaxbase() < 60000) {
			deduction = totalPensionPlan * 37 / 100;
		} else if (pensionPlan.getTaxbase() >= 60000
				&& pensionPlan.getTaxbase() < 300000) {
			deduction = totalPensionPlan * 45 / 100;
		} else if (pensionPlan.getTaxbase() > 300000) {
			deduction = totalPensionPlan * 47 / 100;
		} else {
			deduction = 0;
		}

		return new ResponseEntity<>(deduction, HttpStatus.OK);
	}

}
