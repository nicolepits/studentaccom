package gr.hua.dit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name="name")
	String name;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="department_id")
	Department department;
	
	@Column(name="email")
	String email;
	
	@Column(name="phone_number")
	String phoneNumber;
	
	@Column(name="points")
	int points;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="form_id")
	Application form;
	
	@Column(name="number_of_siblings")
	int numberOfSiblings;
	
	@Column(name="activation")
	String activation;
	
	public Student(int id, String name, Department department, String email, String phoneNumber, int points,
			Application form, int numberOfSiblings,String activation) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.points = points;
		this.form = form;
		this.numberOfSiblings = numberOfSiblings;
		this.activation= activation;
	}

	public Student() {
		
	}; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Application getForm() {
		return form;
	}

	public void setForm(Application form) {
		this.form = form;
	}

	public int getNumberOfSiblings() {
		return numberOfSiblings;
	}

	public void setNumberOfSiblings(int numberOfSiblings) {
		this.numberOfSiblings = numberOfSiblings;
	}
	
	
	
	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	@Override
	   public String toString() {
	           return "Student [id=" + id + ", name=" + name + ", department_id=" + department + ", email=" + email + ",phone_number="+phoneNumber+", points="+points+", form_id="+form+",number_of_siblings="+numberOfSiblings+"]";
	   }
}
