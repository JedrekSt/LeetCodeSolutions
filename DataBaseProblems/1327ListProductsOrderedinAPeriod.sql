/* Write your T-SQL query statement below */
SELECT P.product_name, SUM(S2.unit) AS unit FROM 
Products P INNER JOIN 
Orders S2
ON P.product_id = S2.product_id
WHERE FORMAT(S2.order_date,'yyyy-MM') = '2020-02'
GROUP BY P.product_name
HAVING SUM(S2.unit) >= 100