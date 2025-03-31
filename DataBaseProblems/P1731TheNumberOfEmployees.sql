SELECT 
E1.employee_id,
E1.name,
COUNT(*) as reports_count,
ROUND(AVG(CAST(E2.age AS FLOAT)),0) as average_age FROM 
Employees E1 INNER JOIN Employees E2 
ON E1.employee_id = E2.reports_to
GROUP BY E1.employee_id, E1.name
ORDER BY E1.employee_id