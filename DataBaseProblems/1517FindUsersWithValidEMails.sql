# Write your MySQL query statement below
SELECT * FROM Users WHERE
RIGHT(mail,13) LIKE '@leetcode.com' 
AND LEFT(mail,1) REGEXP '^[a-zA-Z]+$' AND
LEFT(mail, LENGTH(mail) - 13) REGEXP '^[a-zA-Z0-9._-]+$'