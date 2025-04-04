/* Write your T-SQL query statement below */
SELECT P.product_id, P.new_price as "price" FROM Products P
WHERE P.change_date IN (
    SELECT MAX(change_date) FROM Products
    WHERE change_date <= '2019-08-16' AND product_id = P.product_id
    GROUP BY product_id
    )
UNION
SELECT P.product_id, 10 AS "price" FROM Products P
GROUP BY P.product_id
HAVING MIN(P.change_date) > '2019-08-16'