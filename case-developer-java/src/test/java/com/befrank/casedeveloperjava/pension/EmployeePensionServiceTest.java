package com.befrank.casedeveloperjava.pension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeePensionServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeePensionService employeePensionService;

    @Test
    void pensionCheck_example1() throws EmployeeNotFoundException {
        var employeeId = UUID.randomUUID();

        Employee employee = new Employee.EmployeeBuilder()
                .id(employeeId)
                .age(60)
                .pensionValue(100000)
                .name("name")
                .employmentStatus(EmploymentStatus.parttime(80))
                .salary(5000)
                .build();

        Employer employer = new Employer.EmployerBuilder()
                .id(UUID.randomUUID())
                .employees(List.of(employee))
                .build();

        employee.setEmployer(employer);

        when(employeeRepository.getEmployeeById(any())).thenReturn(Optional.of(employee));

        //todo move everything to BigDecimal
        var x = employeePensionService.calculateTotalPensionValue(employeeId, 61);
        var z = BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_EVEN);

        assertThat(z).isEqualTo(BigDecimal.valueOf(104802.68));
    }

    @Test
    void pensionCheck_example2() throws EmployeeNotFoundException {
        var employeeId = UUID.randomUUID();

        Employee employee = new Employee.EmployeeBuilder()
                .id(employeeId)
                .age(60)
                .pensionValue(100000)
                .name("name")
                .employmentStatus(EmploymentStatus.parttime(80))
                .salary(5000)
                .build();

        Employer employer = new Employer.EmployerBuilder()
                .id(UUID.randomUUID())
                .employees(List.of(employee))
                .build();

        employee.setEmployer(employer);

        when(employeeRepository.getEmployeeById(any())).thenReturn(Optional.of(employee));

        //todo move everything to BigDecimal
        var x = employeePensionService.calculateTotalPensionValue(employeeId, 65);
        var z = BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_EVEN);

        assertThat(z).isEqualTo(BigDecimal.valueOf(125498.08));
    }

}