package gr.hua.dit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.dao.ApplicationDAO;
import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.entity.AppResult;
import gr.hua.dit.entity.Application;
import gr.hua.dit.entity.Rank;
import gr.hua.dit.entity.RankList;
import gr.hua.dit.entity.Student;
import gr.hua.dit.service.ApplicationService;
import gr.hua.dit.service.StudentService;;

@Controller
@RequestMapping("/student")
public class StudentController {

	// inject the student dao
	@Autowired
	private StudentService studentService;

	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private RankList rankList;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		// get students from dao
		List<Student> students = studentService.getStudents();

		// add the students to the model
		model.addAttribute("students", students);
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
		Application app = new Application();
		student.setForm(app);
		studentService.saveStudent(student);
		return "redirect:/student/list";
	}

	@GetMapping("/addApp")
	public String showApp(Model model) {
		// create model attribute to get form data
		Application app = new Application();
		model.addAttribute("app", app);
		return "appForm";
	}

	@PostMapping("/saveApp")
	public String saveApp(@ModelAttribute("application") Application application) {

		/*
		 * Student s = new Student(); Application app = new Application();
		 * 
		 * s = studentService.getStudent(application.getId()); app =
		 * applicationService.getApp(s.getForm().getId());
		 * application.setId(s.getForm().getId());
		 * 
		 * /* s.getForm().setIncome(application.getIncome());
		 * s.getForm().setYearsOfAccomodation(application.getYearsOfAccomodation());
		 * s.getForm().setYearsOfStudies(application.getYearsOfStudies());
		 * s.getForm().setPermanentResidency(application.getPermanentResidency());
		 * s.getForm().setNumberOfSiblings(application.getIncome());
		 * s.getForm().setCityOfStudies(application.getCityOfStudies());
		 */
		// s.calculatePoints(); //calculate points
		// studentService.updateStudent(s); */
		application.calculatePoints();
		applicationService.updateApp(application);

		return "redirect:/studentMenu";

	}

	@GetMapping("/changeInfo")
	public String showChangeInfo(Model model) {

		return "change-com-info";
	}

	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("student") Student student) {
		Student s = studentService.getStudent(student.getId());

		s.setEmail(student.getEmail());
		s.setPhoneNumber(student.getPhoneNumber());
		studentService.updateStudent(s);
		return "redirect:/studentMenu";

	}

	@GetMapping("/viewRank")
	public String shoeViewRank(Model model) {

		return "view-rank";
	}

	@GetMapping("/viewResultRank")
	public String viewRank(@ModelAttribute("id") int id,Model model) {
			List<Application> apps = applicationService.getApplications();
	    	
	    	Application app = applicationService.getApp(id);
	    	
	    	ArrayList<Rank> ranks = new ArrayList();
	    	
			
			for(int i=0;i<apps.size(); i++) {
				Rank l= new Rank();
				l.setId(apps.get(i).getId());
				l.setPoints(apps.get(i).getPoints());
				
				ranks.add(l);
			}
			
			this.rankList.setRankList(ranks);
			Rank myRank = new Rank(); //Assemble user's rank object 
			myRank.setPoints(app.getPoints());
			myRank.setId(id);
			
			int index = this.rankList.getIndexOfRank(id);
			
			String myString;
			if(index<=100) {
				myString = "Accepted!";
			} else {
				myString = "Your application is declined. We're sorry!";
			}
			AppResult myResult = new AppResult(index,myString);
			System.out.println(myResult.getIndex());
			System.out.println(myResult.getResult());
			
			model.addAttribute("myResult", myResult);
			return "view-result-rank";
		}
}
