package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.dao.EmployeeDAO;
import gr.hua.dit.entity.Employee;
import gr.hua.dit.entity.Student;
import gr.hua.dit.service.StudentService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String listEmployee(Model model) {
		// get students from dao
        List<Employee> employees = employeeDAO.getEmployees();
        
        // add the students to the model
        model.addAttribute("employees",employees);
		return "list-employees";
	}
	
	@GetMapping("/showAddForm")
	   public String showAddForm(Model model) {
	           // create model attribute to get form data
	           Employee employee = new Employee();
	           model.addAttribute("employee", employee);
	           return "employee-form";
	   }
	
	@GetMapping("/showActivation")
	   public String showActivation() {
		
	           return "student-activate";
	           
	   }
	
	@PostMapping("/activateStudent")
	   public String activateStudent(@RequestParam("id") int id) {
	       
			Student s = studentService.getStudent(id);
			s.setActivation("yes");
	        studentService.updateStudent(s);
	           return "redirect:/homePage";
	   }
}
