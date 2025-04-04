/* Write your T-SQL query statement below */
SELECT
ROUND(CONVERT(FLOAT,(SELECT COUNT(*) FROM Activity S1 INNER JOIN
(SELECT S2.player_id, MIN(S2.event_date) as "first" FROM Activity S2 GROUP BY S2.player_id) S3
ON S1.player_id = S3.player_id
WHERE DATEADD(DAY,1,S3.first) = S1.event_date) )/ 
(SELECT COUNT(DISTINCT player_id) FROM Activity) ,2)
AS "fraction"