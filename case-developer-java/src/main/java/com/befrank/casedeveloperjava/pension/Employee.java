package com.befrank.casedeveloperjava.pension;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private UUID id;

    private String name;
    private int age;
    private String address;
    private Date dateOfBirth;

    @JsonManagedReference
    @ManyToOne
    private Employer employer;

    private double salary;

    @Convert(converter = EmploymentStatusConverter.class)
    private EmploymentStatus employmentStatus;

    private double pensionValue;

}
