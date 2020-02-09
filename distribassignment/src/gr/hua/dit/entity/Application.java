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

	@Column(name = "number_of_siblings")
	int numberOfSiblings;

	@Column(name = "city_of_studies")
	String cityOfStudies;
	
	@Column(name = "points")
	int points;

	public Application(int id, int income, String permanentResidency, int yearsOfStudies, int yearsOfAccomodation,
			int numberOfSiblings, String cityOfStudies) {
		super();
		this.id = id;
		this.income = income;
		this.permanentResidency = permanentResidency;
		this.yearsOfStudies = yearsOfStudies;
		this.yearsOfAccomodation = yearsOfAccomodation;
		this.numberOfSiblings = numberOfSiblings;
		this.cityOfStudies = cityOfStudies;
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

	public int getNumberOfSiblings() {
		return numberOfSiblings;
	}

	public void setNumberOfSiblings(int numberOfSiblings) {
		this.numberOfSiblings = numberOfSiblings;
	}

	public String getCityOfStudies() {
		return cityOfStudies;
	}

	public void setCityOfStudies(String cityOfStudies) {
		this.cityOfStudies = cityOfStudies;
	}
	
	public void calculatePoints() {
		this.points=0;

		if (this.income < 10000) { // check for income
			this.points = this.points + 100;
		} else if (this.income >= 10000 && this.income <= 15000) {
			this.points = this.points + 30;
		} else if (this.income == 0) {
			this.points = -1;// if points=-1 then the student deserve free home

		} else {
			this.points = 0;
		}

		if (this.numberOfSiblings != 0) { // check for siblings who also study
			points = this.numberOfSiblings * 20;
		}
		;
		if (this.permanentResidency != this.cityOfStudies) { // checks for permanent residency
			this.points = this.points + 50;
		}
		
		if (this.yearsOfAccomodation != 0) {
			this.points = this.points - 10 * this.yearsOfAccomodation;
		}
		
		if (this.yearsOfStudies > 4) {
			this.points = -2;
			 // if points=-2 then student out of residence
		}
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}	

}
