# total_distance는 이제 숫자가 아닌 문자열이기 때문에 order by를 하면 안됨
SELECT route
    , CONCAT(ROUND(SUM(d_between_dist), 1), 'km') AS total_distance
    , CONCAT(ROUND(AVG(d_between_dist), 2), 'km') AS average_distance
FROM subway_distance
GROUP BY route
ORDER BY ROUND(SUM(d_between_dist), 2) DESC
;