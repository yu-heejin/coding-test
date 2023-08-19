-- 코드를 입력하세요
SELECT
    P.product_code
    , SUM(O.sales_amount) * P.price AS sales
FROM
    product P
    JOIN offline_sale O ON P.product_id = O.product_id
GROUP BY
    P.product_code
ORDER BY
    sales DESC
    , P.product_code
;