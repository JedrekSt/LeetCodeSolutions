/* Write your T-SQL query statement below */
SELECT S1.category, ISNULL(S2.accounts_count,0) as "accounts_count" FROM
(
    SELECT 'Low Salary' as "category" 
    UNION 
    SELECT 'Average Salary' as "category" 
    UNION 
    SELECT 'High Salary' as "category" 
) S1
LEFT OUTER JOIN
(SELECT A.category, COUNT(1) as "accounts_count" FROM (
    SELECT (
        CASE WHEN income < 20000 THEN 'Low Salary'
            WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
            ELSE 'High Salary' END 
    ) AS "category" FROM Accounts 
) A
GROUP BY A.category) S2
ON S1.category = S2.category

