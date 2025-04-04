/*Write your T-SQL query statement below */
WITH nums AS(
    (SELECT I1.pid FROM Insurance I1 INNER JOIN Insurance I2
    ON I1.tiv_2015 = I2.tiv_2015 AND I1.pid != I2.pid
    GROUP BY I1.pid
    HAVING COUNT(*) > 0)
    INTERSECT
    (SELECT DISTINCT I1.pid FROM Insurance I1 
    LEFT OUTER JOIN Insurance I2
    ON I1.lat = I2.lat AND I1.lon = I2.lon AND I1.pid != I2.pid
    WHERE I2.pid IS NULL)
)

SELECT ROUND(SUM(I.tiv_2016),2) AS 'tiv_2016' FROM 
Insurance I INNER JOIN nums N
ON I.pid = N.pid


