package gr.hua.dit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import gr.hua.dit.entity.Department;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name="name")
	String name;
	
	  @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
              CascadeType.DETACH, CascadeType.REFRESH})
	  @JoinColumn(name="department_id")
	private Department department;
	
	@Column(name="email")
	String email;
	
	@Column(name="phone_number")
	String phoneNumber;
	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="form_id")
	Application form;
	
	@Column(name="activation")
	String activation;
	
	public Student(String name,int departmentId, String email, String phoneNumber) {
		super();
		this.name = name;
		this.department.id= departmentId;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Student() {
		this.form= new Application();
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

	

	public Application getForm() {
		return form;
	}

	public void setForm(Application form) {
		this.form = form;
	}

	
	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}
	
	
	
	@Override
	   public String toString() {
	           return "Student [id=" + id + ", name=" + name + ", department_id=" + department + ", email=" + email + ",phone_number="+phoneNumber+"]";
	   }
}
