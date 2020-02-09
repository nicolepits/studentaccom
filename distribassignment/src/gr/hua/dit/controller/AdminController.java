package gr.hua.dit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.*;
import gr.hua.dit.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private AuthoritiesService authService;
	
	@Autowired
	private ServiceService servService;
	
	
	@GetMapping("/manageUsers")
	public String showManageUsers() {
		return "manage-users-menu";
	}
	
	
	@GetMapping("/manageRoles")
	public String showManageRoles() {
		return "manage-roles-menu";
	}
	
	@GetMapping("/manageServices")
	public String showManageServices() {
		return "manage-services-menu";
	}
	
	@GetMapping("/addUser")
	public String showAddUser(Model model) {
		// create model attribute to get form data
		User user= new User();
		model.addAttribute("user", user);
		return "add-user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		// save the user using the service
		userService.saveUser(user);
		return "redirect:/adminMenu";
	}
	
	@GetMapping("/deleteUserForm")
	public String showDeleteUser() {
		return "delete-user";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam("username") String username) {
		userService.deleteUser(username);
		return "redirect:/adminMenu";
	}
	
	@GetMapping("/showUpdateUser")
	public String showUpdateUser() {
		return "update-user";
	
	}
	
	@PostMapping("/updateUser")
	public String updateStudent(@ModelAttribute("user") User user) {
		User u = userService.getUser(user.getUsername());
		
		u.setPassword(user.getPassword()); 
	    userService.updateUser(u);
		return "redirect:/adminMenu";
		
	}
	
	@GetMapping("/showAddRole")
	public String showAddRole(Model model) {
		Authorities auth = new Authorities();
		model.addAttribute("authorities", auth);
		return "add-new-role";
	}
	
	@PostMapping("/addRole")
	public String addRole(@ModelAttribute("authorities") Authorities auth) {
		authService.saveAuthority(auth);
		return "redirect:/adminMenu";
	} 
	
	@GetMapping("/showUpdateRole")
	public String showUpdateRole(Model model) {
		Authorities auth = new Authorities();
		model.addAttribute("authorities", auth);
		return "update-role";
	}
	
	@PostMapping("/updateRole")
	public String updateRole(@ModelAttribute("authorities") Authorities auth) {
		Authorities a = authService.getAuthority(auth.getUsername());
		
		a.setAuthority(auth.getAuthority());
		authService.updateAuthority(a);
		
		return "redirect:/adminMenu";
	}
	
	@GetMapping("/showDeleteRole")
	public String showDeleteRole(Model model) {
		Authorities auth = new Authorities();
		model.addAttribute("authorities", auth);
		return "delete-role";
	}
	
	@PostMapping("/deleteRole")
	public String deleteRole(@RequestParam("username") String username) {
	    
		authService.deleteAuthority(username);
		
		return "redirect:/adminMenu";
	}
	
	@GetMapping("/showAddService")
	public String showAddService(Model model) {
		Services service= new Services();
		model.addAttribute("services", service);
		return "add-new-service";
	}
	
	@PostMapping("/addService")
	public String addService(@ModelAttribute("services") Services service) {
		System.out.println(service.getName());
		System.out.println(service.getAuthority());
		servService.saveService(service);
		return "redirect:/adminMenu";
	} 
	
	@GetMapping("/showDeleteService")
	public String showDeleteService(Model model) {
		
		return "delete-service";
	}
	
	@PostMapping("/deleteService")
	public String deleteRole(@RequestParam("id") int id) {
	    
		servService.deleteService(id);
		
		return "redirect:/adminMenu";
	}
	
	@GetMapping("/showUpdateService")
	public String showUpdateService(Model model) {
		Authorities auth = new Authorities();
		model.addAttribute("authorities", auth);
		return "update-service";
	}
	
	@PostMapping("/updateService")
	public String updateService(@ModelAttribute("services") Services service) {
		Services s = servService.getService(service.getId());
		
		s.setAuthority(service.getAuthority());
		servService.updateService(s);
		
		return "redirect:/adminMenu";
	}
	
}
