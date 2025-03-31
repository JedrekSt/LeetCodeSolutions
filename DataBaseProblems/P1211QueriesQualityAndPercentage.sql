SELECT 
Q1.query_name,
ROUND(AVG(CAST(Q1.rating AS FLOAT) / CAST(Q1.position AS FLOAT)),2) as "quality",
(SELECT 
    ROUND(CAST(SUM(CASE WHEN Q2.rating < 3 THEN 1 ELSE 0 END)AS FLOAT) * 100 / CAST(COUNT(1) AS FLOAT),2)  
    FROM Queries Q2 WHERE Q2.query_name = Q1.query_name) as "poor_query_percentage"
FROM Queries Q1
GROUP BY Q1.query_name