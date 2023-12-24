package com.Ems.EmployeeManagementSystem2.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class DeleteEmployeeController {

    @DeleteMapping("/employees/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        try {
            // Your logic to delete the employee by ID
            // employeeRepository.deleteById(id);
            return ResponseEntity.ok("Employee deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete employee");
        }
    }


    @GetMapping("/deleteEmployee")
    public String handleDelete(){
        return "deleteEmployee";
    }


}
