/* Write your T-SQL query statement below */

SELECT S1.user_id, 
ROUND(CAST(SUM(CASE WHEN C.action IS NULL OR C.action = 'timeout' THEN 0 ELSE 1 END)AS FLOAT) / COUNT(*),2) 
AS "confirmation_rate" FROM
Signups S1 LEFT OUTER JOIN Confirmations C ON
S1.user_id = C.user_id
GROUP BY S1.user_id