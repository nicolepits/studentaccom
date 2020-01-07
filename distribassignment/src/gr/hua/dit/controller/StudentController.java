package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.entity.Student;;

@Controller
@RequestMapping("/student")
public class StudentController {

	// inject the student dao
    @Autowired
    private StudentDAO studentDAO;
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		// get students from dao
        List<Student> students = studentDAO.getStudents();
        
        // add the students to the model
        model.addAttribute("students",students);
		return "list-students";
	}
	
	@GetMapping("/showAddForm")
	   public String showAddForm(Model model) {
	           // create model attribute to get form data
	           Student student = new Student();
	           model.addAttribute("student", student);
	           return "student-form";
	   }
	
	@PostMapping("/saveStudent")
	   public String saveStudent(@ModelAttribute("student") Student student) {
	           // save the student using the service
	           studentDAO.saveStudent(student);
	           
	           return "redirect:/student/list";
	   }
	
}
