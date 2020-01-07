package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Employee {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	    public int id;
		
		@Column(name="name")
		public String name;
		
		@Column(name = "department_id")
	    public Department department;
	   
		@Column(name = "type")
	    public String type;
	   
	   public Employee(int id,Department department,String type) {
		   this.id=id;
		   this.department=department;
		   this.type=type;
	   }

	   public Employee() {
		   
	   }
	   
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		
	    
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		static void activateStudent(Student student) {
			student.setActivation("YES");
		}
		
		@Override
		   public String toString() {
		           return "Employee [id=" + id + ", name=" + name + ", department_id=" + department + ", type=" + type +"]";
		   }
	}		
