/* Write your T-SQL query statement below */
SELECT ROUND(CONVERT(FLOAT, (SELECT COUNT(D.customer_id) FROM Delivery D
            WHERE D.order_date IN (
                SELECT MIN(order_date) FROM Delivery
                WHERE customer_id = D.customer_id
                GROUP BY customer_id
            ) AND D.order_date = D.customer_pref_delivery_date)  * 100) / 
(SELECT COUNT(DISTINCT customer_id) FROM Delivery),2) AS "immediate_percentage"
