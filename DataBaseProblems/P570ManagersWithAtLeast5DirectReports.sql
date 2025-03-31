(SELECT s1.name FROM 
Employee s1 INNER JOIN Employee s2 
ON s1.id = s2.managerId
GROUP BY s1.id,s1.name
HAVING COUNT(s1.id) > 4); 