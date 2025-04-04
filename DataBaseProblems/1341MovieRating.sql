/* Write your T-SQL query statement below */
SELECT (SELECT TOP 1 U.name as "results" FROM Users U
INNER JOIN MovieRating M ON
U.user_id = M.user_id
GROUP BY U.name
ORDER BY COUNT(*) DESC, U.name ASC) as "results"
UNION ALL
SELECT (SELECT TOP 1 Mo.title AS "results"
FROM Movies Mo
INNER JOIN MovieRating M
    ON Mo.movie_id = M.movie_id
WHERE FORMAT(M.created_at, 'yyyy-MM') = '2020-02'
GROUP BY Mo.title
ORDER BY AVG(CONVERT(FLOAT,M.rating)) DESC, Mo.title ASC) as "results"

