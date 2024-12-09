package com.befrank.casedeveloperjava.pension;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EmploymentStatusConverter implements AttributeConverter<EmploymentStatus, String> {

    @Override
    public String convertToDatabaseColumn(EmploymentStatus employmentStatus) {
        return employmentStatus.toString();
    }

    @Override
    public EmploymentStatus convertToEntityAttribute(String dbData) {
        return dbData != null ? EmploymentStatus.fromString(dbData) : null;
    }
}

