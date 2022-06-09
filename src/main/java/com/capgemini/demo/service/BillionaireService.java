package com.capgemini.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.demo.dao.BillionaireDao;
import com.capgemini.demo.exception.ResourceNotFoundException;
import com.capgemini.demo.model.Billionaire;

@Service
@Transactional
public class BillionaireService {

	@Autowired
	private BillionaireDao billionaireDao;

	/*
	 * Post into H2 database
	 */
	public Billionaire saveBillionaire(Billionaire billionaire) {
		return billionaireDao.save(billionaire);
	}

	/*
	 * Get List from H2 db
	 */
	public List<Billionaire> getBillionaires() {
		return billionaireDao.findAll();
	}

	public List<Billionaire> findByCareer(String career) {
		return billionaireDao.findByCareer(career);
	}

	public List<Billionaire> findByLastName(String lastName) {
		return billionaireDao.findByLastName(lastName);
	}

	/*
	 * Update Job in H2 DB
	 */

	public Billionaire updateBillionaire(Billionaire billionaire)
			throws ResourceNotFoundException {

		Optional<Billionaire> oldBillionaire = billionaireDao
				.findById(billionaire.getId());

		if (!oldBillionaire.isPresent()) {
			throw new ResourceNotFoundException("Resource Not Found!!!!");
		} else {
			Billionaire updatedBillionaire = oldBillionaire.get();
			updatedBillionaire.setFirstName(billionaire.getFirstName());
			updatedBillionaire.setLastName(billionaire.getLastName());
			updatedBillionaire.setCareer(billionaire.getCareer());
			billionaireDao.save(updatedBillionaire);
			return updatedBillionaire;
		}
	}

	/*
	 * Delete Job
	 */
	public void deleteBillionaire(int id) throws ResourceNotFoundException {
		Optional<Billionaire> deletedBillionaire = billionaireDao.findById(id);
		if (!deletedBillionaire.isPresent()) {
			throw new ResourceNotFoundException("Resource Not Found!!!!");
		} else {
			billionaireDao.delete(deletedBillionaire.get());
		}
	}
}
