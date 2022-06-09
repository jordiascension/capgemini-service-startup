package com.capgemini.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.demo.model.Billionaire;

public interface BillionaireDao extends JpaRepository<Billionaire, Integer> {

	List<Billionaire> findByCareer(String career);

	List<Billionaire> findByLastName(String lastName);

}
