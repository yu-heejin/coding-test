# 시간대 테이블
WITH RECURSIVE time_table AS (
    SELECT 0 AS hour
    UNION
    SELECT hour + 1
    FROM time_table
    WHERE hour < 23
),
# 각 시간대별 입양 정보
outs_per_time AS (
    SELECT animal_id
        , HOUR(datetime) AS out_time
    FROM animal_outs
)

SELECT T.hour
    , COUNT(P.animal_id) AS count
FROM outs_per_time P
    RIGHT JOIN time_table T ON T.hour = P.out_time
GROUP BY T.hour
ORDER BY T.hour;