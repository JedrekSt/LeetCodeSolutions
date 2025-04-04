/* Write your T-SQL query statement below */

SELECT S1.id, (
    CASE 
    WHEN (SELECT COUNT(*) FROM Seat) % 2 = 1 AND S1.id = (SELECT COUNT(*) FROM Seat) THEN S1.student
    WHEN S1.id % 2 = 0 THEN S3.student 
    ELSE S2.student 
    END) as student FROM 
Seat S1 INNER JOIN Seat S2
ON S2.id = (CASE WHEN (S1.id + 1) > (SELECT COUNT(*) FROM Seat) THEN 1 ELSE S1.id + 1 END)
INNER JOIN Seat S3
ON S3.id = (CASE WHEN (S1.id - 1) < 1 THEN (SELECT COUNT(*) FROM Seat) ELSE S1.id - 1 END)
ORDER BY S1.id