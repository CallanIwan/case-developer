package com.befrank.casedeveloperjava.pension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeePensionService {

    private final EmployeeRepository employeeRepository;

    public EmployeePensionService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public double yearlyPremium(double salary, double franchise, double employmentPercentage, double premiumPercentage) throws EmployeeNotFoundException {

        double fullTimeSalary = salary * 12;
        double adjustedEmploymentPercentage = employmentPercentage / 100;
        double adjustedPremiumPercentage = premiumPercentage / 100;

        return (fullTimeSalary - franchise) * adjustedEmploymentPercentage * adjustedPremiumPercentage;
    }

    public double expectedYearlyValue(double currentPensionValue, double yearlyPremium) throws EmployeeNotFoundException {
        double pensionReturn = 3;

        double adjustedPensionReturn = pensionReturn / 100;
        return currentPensionValue + yearlyPremium +
                (currentPensionValue + yearlyPremium / 2) * adjustedPensionReturn;
    }

    public double calculateTotalPensionValue(UUID employeeId, int pensionAge) throws EmployeeNotFoundException {
        var employee = employeeRepository.getEmployeeById(employeeId)
                .orElseThrow(EmployeeNotFoundException::new);

        double yearlyPremium = yearlyPremium(
                employee.getSalary(),
                employee.getEmployer().getFranchise(),
                employee.getEmploymentStatus().getPercentage(),
                employee.getEmployer().getPremiumPercentage());

        double currentPensionValue = employee.getPensionValue();
        int age = employee.getAge();

        int yearsTillPension = pensionAge - age;

        for (int i = 0; i < yearsTillPension; i++) {
            currentPensionValue = expectedYearlyValue(currentPensionValue, yearlyPremium);
        }

        return currentPensionValue;
    }
}
