WITH count_sum AS (
    SELECT SUM(total_order) AS total_order
        , flavor
    FROM (
        SELECT * FROM first_half
        UNION ALL
        SELECT * FROM july
    ) R
    GROUP BY R.flavor
)

SELECT flavor
FROM count_sum
ORDER BY total_order DESC
LIMIT 3;