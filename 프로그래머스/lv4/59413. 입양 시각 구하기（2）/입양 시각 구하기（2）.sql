WITH RECURSIVE time_table AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1 FROM time_table
    WHERE hour < 23
)

SELECT T.hour
    , COUNT(A.animal_id) AS count
FROM animal_outs A
    RIGHT JOIN time_table T ON T.hour = HOUR(A.datetime)
GROUP BY
    T.hour
ORDER BY T.hour
;