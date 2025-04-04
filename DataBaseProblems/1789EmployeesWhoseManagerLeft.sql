SELECT E1.employee_id FROM Employees E1
WHERE E1.salary < 30000 AND E1.manager_id NOT IN (
    SELECT employee_id FROM Employees
) ORDER BY E1.employee_id