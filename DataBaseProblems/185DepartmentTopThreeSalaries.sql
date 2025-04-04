/* Write your T-SQL query statement below */
SELECT D.name as Department, E1.name as Employee, E1.salary as Salary FROM Employee E1
INNER JOIN Department D
ON D.id = E1.departmentId
WHERE E1.id IN (
    SELECT S1.id FROM (
        SELECT * FROM Employee A1
        WHERE A1.departmentId = E1.departmentId
    ) S1 LEFT OUTER JOIN (
        SELECT * FROM Employee A2
        WHERE A2.departmentId = E1.departmentId
    ) S2
    ON S1.salary < S2.salary
    GROUP BY S1.id
    HAVING COUNT( DISTINCT S2.salary) < 3
)