package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "income")
	int income;
	
	@Column(name = "permanent_residency")
	String permanentResidency;
	
	@Column(name = "years_of_studies")
	int yearsOfStudies;
	
	@Column(name = "years_of_accomodation")
	int yearsOfAccomodation;
	
	public Application(int id,int income, String permanentResidency, int yearsOfStudies, int yearsOfAccomodation) {
		super();
		this.id = id;
		this.income = income;
		this.permanentResidency = permanentResidency;
		this.yearsOfStudies = yearsOfStudies;
		this.yearsOfAccomodation = yearsOfAccomodation;
	}
	
	public Application() {
		
	}
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getPermanentResidency() {
		return permanentResidency;
	}
	public void setPermanentResidency(String permanentResidency) {
		this.permanentResidency = permanentResidency;
	}
	public int getYearsOfStudies() {
		return yearsOfStudies;
	}
	public void setYearsOfStudies(int yearsOfStudies) {
		this.yearsOfStudies = yearsOfStudies;
	}
	public int getYearsOfAccomodation() {
		return yearsOfAccomodation;
	}
	public void setYearsOfAccomodation(int yearsOfAccomodation) {
		this.yearsOfAccomodation = yearsOfAccomodation;
	}
	
	
}
