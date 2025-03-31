SELECT Pr.product_id ,
ROUND(
    CAST(SUM(Pr.price * CASE WHEN Uni.units IS NULL THEN 0 ELSE Uni.units END) AS FLOAT) / 
    CASE WHEN SUM(CASE WHEN Uni.units IS NULL THEN 0 ELSE Uni.units END) = 0 THEN CAST(1 AS FLOAT) ELSE CAST(SUM(Uni.units) AS FLOAT) END
    , 2) as "average_price"
FROM Prices Pr LEFT OUTER JOIN UnitsSold Uni
ON Pr.product_id = Uni.product_id AND Uni.purchase_date BETWEEN Pr.start_date AND Pr.end_date
GROUP BY Pr.product_id