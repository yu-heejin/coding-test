-- 코드를 입력하세요
SELECT
    HOUR(datetime) AS hour
    , COUNT(*) AS count
FROM
    animal_outs
GROUP BY
    HOUR(datetime)
HAVING
    hour BETWEEN 9 AND 19
ORDER BY
    hour
;