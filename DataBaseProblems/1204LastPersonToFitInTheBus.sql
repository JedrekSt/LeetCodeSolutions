/* Write your T-SQL query statement below */
SELECT TOP 1 K.person_name FROM
(SELECT Q1.person_name, SUM(Q2.weight) AS "total_weight" FROM Queue Q1
INNER JOIN Queue Q2
ON Q1.turn >= Q2.turn
GROUP BY Q1.person_name, Q1.turn
HAVING SUM(Q2.weight) <= 1000) K 
ORDER BY K.total_weight DESC