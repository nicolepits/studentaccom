package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import gr.hua.dit.dao.EmployeeDAO;
import gr.hua.dit.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
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
	
	@PostMapping("/saveEmployee")
	   public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	           // save the student using the service
	           employeeDAO.saveEmployee(employee);
	           
	           return "redirect:/employee/list";
	   }
}
