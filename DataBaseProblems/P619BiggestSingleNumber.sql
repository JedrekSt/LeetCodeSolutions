SELECT MAX(num) as num FROM
(SELECT num 
FROM MyNumbers
GROUP BY num
HAVING COUNT(1) = 1) as unique_nums