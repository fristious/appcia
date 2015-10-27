package com.Customs.CIA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Customs.CIA.model.Employee;
import com.Customs.CIA.service.EmployeeService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private EmployeeService employeeService;

	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService es) {
		this.employeeService = es;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("name", "Hello World!");
		model.addAttribute("greetings", "Welcome to SHIA Customs!");
		return "home";
	}
	
	@RequestMapping(value="/employee")
	public String listEmployees(Model model){
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", this.employeeService.listEmployee());
		return "employee";
	}
	
	@RequestMapping("/addemployee")
	public String newEmployee(Model model){
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", this.employeeService.listEmployee());
		return "addemployee";
	}
	
	//For add and update employee both
	@RequestMapping(value="/employee/add", method=RequestMethod.POST)
	public String addEmployees(@ModelAttribute("employee") Employee employee){
		if(employee.getEmployeeID()==0){
			//new employee, add it
			this.employeeService.addEmployee(employee);
		}
		else{
			//existing employee, call update
			this.employeeService.updateEmployee(employee);
		}
		return "redirect:/employee";                               
	}
	
	@RequestMapping("/employee/delete/{EmployeeID}")
	public String deleteEmployee(@PathVariable("EmployeeID") int EmployeeID){
		this.employeeService.deleteEmployee(EmployeeID);
		return "redirect:/employee";
	}
	
	@RequestMapping("/employee/edit/{EmployeeID}")
	public String editEmployee(@PathVariable("EmployeeID") int EmployeeID, Model model){
		model.addAttribute("employee", this.employeeService.getEmployeeById(EmployeeID));
		model.addAttribute("employeeList", this.employeeService.listEmployee());
		return "addemployee";
	}
}
