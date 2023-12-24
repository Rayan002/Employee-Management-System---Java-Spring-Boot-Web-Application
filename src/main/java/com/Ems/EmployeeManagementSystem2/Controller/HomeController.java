package com.Ems.EmployeeManagementSystem2.Controller;


import com.Ems.EmployeeManagementSystem2.model.Employee;
import com.Ems.EmployeeManagementSystem2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/home")
    public String home() {
        return "redirect-to-home";
    }

    @PostMapping("/submit")
    public String submitForm(Employee employee) {
        // Save the employee data to the database
        employeeRepository.save(employee);
        return "redirect:/home";
    }
}
