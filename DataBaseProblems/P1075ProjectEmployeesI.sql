SELECT Pr.project_id, ROUND(AVG(Em.experience_years) ,2) as "average_years" FROM
Project PR JOIN Employee Em ON
Pr.employee_id = Em.employee_id
GROUP BY Pr.project_id
ORDER BY Pr.project_id