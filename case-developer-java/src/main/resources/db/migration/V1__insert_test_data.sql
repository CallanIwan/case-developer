INSERT INTO employers (id, franchise, premium_percentage)
VALUES (UNHEX(REPLACE('550e8400-e29b-41d4-a716-446655440000', '-', '')), 15599, 5);

INSERT INTO employees (id, name, age, date_of_birth, address, salary, pension_value, employer_id, employment_status)
VALUES (UNHEX(REPLACE('550e8400-e29b-41d4-a716-446655440001', '-', '')),
        'name', 25, '1993-01-22', 'address', 5000,
        100000,
        (UNHEX(REPLACE('550e8400-e29b-41d4-a716-446655440000', '-', ''))), 'FULL_TIME-100');

INSERT INTO employers_employees (employees_id, employer_id)
VALUES (UNHEX(REPLACE('550e8400-e29b-41d4-a716-446655440001', '-', '')),
        (UNHEX(REPLACE('550e8400-e29b-41d4-a716-446655440000', '-', ''))));
