SELECT unique_id, name FROM 
Employees E1 LEFT OUTER JOIN EmployeeUNI  E2 on E1.id = E2.id 