SELECT
    ICE_INFO.ingredient_type
    , SUM(FIRST_HALF.total_order) AS total_order
FROM
    icecream_info ICE_INFO
    JOIN first_half FIRST_HALF ON ICE_INFO.flavor = FIRST_HALF.flavor
GROUP BY
    ICE_INFO.ingredient_type
ORDER BY
    FIRST_HALF.total_order
;