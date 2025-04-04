/* Write your T-SQL query statement below */
DELETE FROM Person WHERE id NOT IN
(SELECT MIN(P2.id) FROM Person P2 GROUP BY P2.email)
