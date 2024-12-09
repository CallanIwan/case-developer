package com.befrank.casedeveloperjava.pension;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller()
@RequestMapping("/pension")
@CrossOrigin(origins = "http://localhost:4200")
public class PensionController {

    private final EmployeePensionService employeePensionService;

    public PensionController(EmployeePensionService employeePensionService) {
        this.employeePensionService = employeePensionService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> calculator() {
        return employeePensionService.getAllEmployees();
    }

    @PostMapping("/calculator")
    @ResponseBody
    public double calculator(UUID employee, int pensionAge) throws EmployeeNotFoundException {
        return employeePensionService.calculateTotalPensionValue(employee, pensionAge);
    }
}
