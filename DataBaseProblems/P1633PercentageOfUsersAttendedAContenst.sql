SELECT Reg.contest_id ,ROUND(CAST(COUNT(Reg.user_id) AS FLOAT)*100/( SELECT CAST(COUNT(Us.user_id) AS FLOAT) FROM Users Us ),2) as "percentage" FROM
Register Reg INNER JOIN Users U
ON U.user_id = Reg.user_id
GROUP BY Reg.contest_id
ORDER BY "percentage" DESC, contest_id ASC