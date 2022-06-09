package com.capgemini.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.demo.exception.ResourceNotFoundException;
import com.capgemini.demo.model.Billionaire;
import com.capgemini.demo.service.BillionaireService;

@RestController
public class BillionaireController {

	@Autowired
	private BillionaireService billionaireService;

	@GetMapping("/billionaires")
	@CrossOrigin
	public List<Billionaire> getBillionaires() {
		return billionaireService.getBillionaires();
	}

	@GetMapping("/billionaires/{career}")
	@CrossOrigin
	public List<Billionaire> findByCareer(String career) {
		return billionaireService.findByCareer(career);
	}

	@GetMapping("/billionaires/{lastName}")
	@CrossOrigin
	public List<Billionaire> findByLastName(String lastName) {
		return billionaireService.findByLastName(lastName);
	}

	// request body covert json object to java obj
	@PostMapping("/billionaires")
	@CrossOrigin
	public ResponseEntity<Billionaire> saveJob(
			@RequestBody Billionaire billionaire) {
		return new ResponseEntity<Billionaire>(
				billionaireService.saveBillionaire(billionaire),
				HttpStatus.CREATED);
	}

	@PutMapping("/billionaires/{id}")
	@CrossOrigin
	public ResponseEntity<Billionaire> updateBillionaire(
			@RequestBody Billionaire billionaire, @PathVariable("id") int id)
			throws ResourceNotFoundException {
		billionaire.setId(id);
		return new ResponseEntity<Billionaire>(
				billionaireService.updateBillionaire(billionaire),
				HttpStatus.CREATED);
	}

	@DeleteMapping("/billionaires/{id}")
	@CrossOrigin
	public ResponseEntity<String> deleteBillionaire(@PathVariable("id") int id)
			throws ResourceNotFoundException {
		billionaireService.deleteBillionaire(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
