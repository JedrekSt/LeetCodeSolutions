/* Write your T-SQL query statement below */

SELECT S.product_id, S.year as "first_year", S.quantity, S.price FROM Sales S
WHERE S.year IN(
    SELECT MIN(year) FROM Sales
    WHERE product_id = S.product_id
    GROUP BY product_id
)
