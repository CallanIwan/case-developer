package com.befrank.casedeveloperjava.pension;

import lombok.Getter;

@Getter
public class EmploymentStatus {

    private final Type type;
    private final double percentage;

    enum Type {
        FULL_TIME,
        PART_TIME
    }

    private EmploymentStatus(Type type, double percentage) {
        this.type = type;
        this.percentage = percentage;
    }

    public static EmploymentStatus fulltime() {
        return new EmploymentStatus(Type.FULL_TIME, 100);
    }

    public static EmploymentStatus parttime(int percentage) {
        return new EmploymentStatus(Type.PART_TIME, percentage);
    }

    @Override
    public String toString() {
        return type + "-" + percentage;
    }

    public static EmploymentStatus fromString(String employmentStatusString) {
        String[] parts = employmentStatusString.split("-");
        return new EmploymentStatus(Type.valueOf(parts[0]), Double.parseDouble(parts[1]));
    }

}
