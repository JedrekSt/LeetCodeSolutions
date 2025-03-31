SELECT w2.id FROM Weather w1 INNER JOIN Weather w2 ON
DATEADD(DAY,1,w1.recordDate) = w2.recordDate
WHERE w1.temperature < w2.temperature