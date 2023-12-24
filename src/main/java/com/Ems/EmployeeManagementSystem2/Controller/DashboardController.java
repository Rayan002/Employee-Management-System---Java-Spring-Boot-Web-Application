package com.Ems.EmployeeManagementSystem2.Controller;


import com.Ems.EmployeeManagementSystem2.model.Employee;
import com.Ems.EmployeeManagementSystem2.repository.EmployeeRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class DashboardController {

    //for counting
    private final EmployeeRepository employeeRepository;

    public DashboardController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Redirect to the index (home) page

        //for counting
        long TotalEmployee = employeeRepository.count();
        model.addAttribute("TotalEmployee",TotalEmployee);

        long countdevelopers = employeeRepository.countDevelopers();
        model.addAttribute("CountDevelopers",countdevelopers);

        long countdesigner = employeeRepository.countDisigners();
        model.addAttribute("CountDesigner",countdesigner);


        return "dashboard"; // Assuming "index" is the name of your redirect-to-home.html file
    }
}
