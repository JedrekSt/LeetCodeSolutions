/* Write your T-SQL query statement below */


WITH Dates AS(
    SELECT DISTINCT visited_on FROM Customer
)

SELECT S1.visited_on, SUM(S2.amount) as amount ,ROUND(CAST(SUM(S2.amount) AS FLOAT ) / 7,2) as average_amount FROM Dates S1
INNER JOIN Customer S2
ON S2.visited_on BETWEEN DATEADD(DAY,-6,S1.visited_on) AND S1.visited_on
GROUP BY S1.visited_on
HAVING DATEADD(DAY,-6,S1.visited_on) >= MIN(S2.visited_on)
ORDER BY S1.visited_on
