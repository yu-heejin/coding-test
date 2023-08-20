SELECT
    price - (price % 10000) AS price_group
    , COUNT(*) AS products
FROM
    product
GROUP BY
    price_group
ORDER BY
    price_group
;