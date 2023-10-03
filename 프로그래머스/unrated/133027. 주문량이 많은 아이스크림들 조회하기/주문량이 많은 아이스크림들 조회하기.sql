-- 상반기에 판매된 아이스크림의 경우 7월에 판매되지 않는 가능성 O
WITH icecream AS (
    SELECT *
    FROM july
    UNION ALL
    SELECT *
    FROM first_half
)

SELECT flavor
FROM icecream
GROUP BY flavor
ORDER BY SUM(total_order) DESC
LIMIT 3
;