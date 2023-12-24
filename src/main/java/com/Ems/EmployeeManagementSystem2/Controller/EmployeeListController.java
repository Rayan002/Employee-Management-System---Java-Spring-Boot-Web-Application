package com.Ems.EmployeeManagementSystem2.Controller;


import com.Ems.EmployeeManagementSystem2.model.Employee;
import com.Ems.EmployeeManagementSystem2.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeListController {

    private final EmployeeRepository employeeRepository;

    public EmployeeListController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);

        //total -  for counting
        long Total = employeeRepository.count();
        model.addAttribute("totalemployee", Total);

        return "employeeList";
    }



    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        try {
            employeeRepository.deleteEmployeeById(id);
            return "redirect:/dashboard";
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception for debugging
            return "error"; // Redirect to an error page or handle it accordingly
        }
    }


//    Modify employee
    @GetMapping("/modify/{id}")
    public String getEmployeeForModify(@PathVariable long id, Model model) {
        try {
            Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
            model.addAttribute("employee", employee);
            return "modify";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee updatedEmployee) {
        try {
            // Fetch the existing employee from the database
            Employee existingEmployee = employeeRepository.findById(updatedEmployee.getId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            // Update the fields with the new values
            existingEmployee.setFirstname(updatedEmployee.getFirstname());
            existingEmployee.setLastname(updatedEmployee.getLastname());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setQualifications(updatedEmployee.getQualifications());
            existingEmployee.setRole(updatedEmployee.getRole());

            // Save the updated employee
            employeeRepository.save(existingEmployee);

            return "redirect:/dashboard";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }



}
