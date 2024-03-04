WITH RECURSIVE time_table AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1
    FROM time_table
    WHERE hour < 23
)

SELECT T.hour
    , IFNULL(COUNT(A.datetime), 0) AS count
FROM time_table T
    LEFT JOIN animal_outs A ON T.hour = HOUR(A.datetime)
GROUP BY T.hour
;