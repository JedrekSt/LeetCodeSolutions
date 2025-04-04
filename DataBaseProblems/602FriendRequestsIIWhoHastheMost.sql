/* Write your T-SQL query statement below */

WITH Users AS (
    SELECT DISTINCT requester_id as user_id FROM RequestAccepted 
    UNION 
    SELECT DISTINCT accepter_id as user_id FROM RequestAccepted
)

SELECT TOP 1 U.user_id as id, COUNT(*) as num  FROM Users U
INNER JOIN RequestAccepted R
ON U.user_id = requester_id OR U.user_id = accepter_id
GROUP BY U.user_id
ORDER BY COUNT(*) DESC
