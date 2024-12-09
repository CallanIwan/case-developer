package com.befrank.casedeveloperjava.pension;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employer {

    @Id
    private UUID id;

    @JsonBackReference
    @OneToMany
    private List<Employee> employees;

    private final int franchise = 15599;

    private final int premiumPercentage = 5;

}
