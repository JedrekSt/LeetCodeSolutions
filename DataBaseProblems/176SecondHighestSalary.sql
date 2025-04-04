/* Write your T-SQL query statement below */

SELECT (CASE WHEN COUNT(*) = 0 THEN NULL ELSE MAX(salary) END) as SecondHighestSalary FROM Employee 
WHERE salary NOT IN (SELECT MAX(salary) FROM Employee)



