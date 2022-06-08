package com.capgemini.demo.model;

import javax.validation.constraints.Max;

public class PensionPlan {

	@Max(8500)
	private double companyPensionPlan;
	@Max(1500)
	private double personPensionPlan;
	private double taxbase;

	public double getCompanyPensionPlan() {
		return companyPensionPlan;
	}

	public void setCompanyPensionPlan(double companyPensionPlan) {
		this.companyPensionPlan = companyPensionPlan;
	}

	public double getPersonPensionPlan() {
		return personPensionPlan;
	}

	public void setPersonPensionPlan(double personPensionPlan) {
		this.personPensionPlan = personPensionPlan;
	}

	public double getTaxbase() {
		return taxbase;
	}

	public void setTaxbase(double taxbase) {
		this.taxbase = taxbase;
	}

}
