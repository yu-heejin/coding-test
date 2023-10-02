WITH total_sales AS (
    SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date
        , product_id
        , user_id
        , sales_amount
    FROM online_sale
    UNION ALL
    SELECT DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date
        , product_id
        , COALESCE(NULL, NULL) AS user_id
        , sales_amount
    FROM offline_sale
)

SELECT *
FROM total_sales
WHERE sales_date LIKE '2022-03%'
ORDER BY sales_date
    , product_id
    , user_id
;