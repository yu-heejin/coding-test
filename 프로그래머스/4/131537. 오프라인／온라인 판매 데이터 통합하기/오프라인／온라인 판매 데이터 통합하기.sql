# 2022년 3월의 모든 판매 데이터
WITH march_sales_data AS (
    SELECT product_id
        , user_id
        , sales_amount
        , DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date
    FROM online_sale
    WHERE YEAR(sales_date) = '2022'
        AND MONTH(sales_date) = '03'
    UNION ALL
    SELECT product_id
        , NULL AS user_id
        , sales_amount
        , DATE_FORMAT(sales_date, '%Y-%m-%d') AS sales_date
    FROM offline_sale
    WHERE YEAR(sales_date) = '2022'
        AND MONTH(sales_date) = '03'
)

SELECT sales_date
    , product_id
    , user_id
    , sales_amount
FROM march_sales_data
ORDER BY sales_date
    , product_id
    , user_id
;