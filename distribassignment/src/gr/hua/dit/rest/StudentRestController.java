package gr.hua.dit.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.*;
import gr.hua.dit.service.ApplicationService;
import gr.hua.dit.service.RankService;
import gr.hua.dit.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
	
	@Autowired
    private StudentService studentService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired 
	private RankService rankService;

    @Autowired
    private StudentList studentList;
    
    @Autowired
    private RankList rankList;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
    public Student getStudent(@PathVariable("id") int id) {

            Student student = studentService.getStudent(id);
            System.out.println("student :" + student);

            return student;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
    public StudentList getStudent() {

            List<Student> students = studentService.getStudents();
            System.out.println("students :" + students);
            this.studentList.setStudentList(students);
            return this.studentList;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
    public Application createApp(@RequestBody ApplicationForm applicationForm) {
            Application application = new Application(applicationForm.id,applicationForm.income,applicationForm.permanentResidency,applicationForm.yearsOfStudies,applicationForm.yearsOfAccomodation,applicationForm.numberOfSiblings,applicationForm.cityOfStudies);
            application.calculatePoints();
            System.out.println("application :" + application);
    		applicationService.updateApp(application);
            return application;

    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/change", method = RequestMethod.PUT, produces = { "application/json", "application/xml" })
    public Student changeInfo(@RequestBody StudentChange params) {
    //(@RequestParam("id") int id,@RequestParam("email") String email,@RequestParam("phone_number") String phoneNumber) {
    		
    		Student s = studentService.getStudent(params.id);
		
    		s.setEmail(params.email);
    		s.setPhoneNumber(params.phoneNumber); 
    		studentService.updateStudent(s);
            return s;

    }
    
    @RequestMapping(value = "/rank", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
    public int getRank(@RequestParam("id") int id) {
    	
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
		
        return index;
        
    }
    
    
	
	

}
