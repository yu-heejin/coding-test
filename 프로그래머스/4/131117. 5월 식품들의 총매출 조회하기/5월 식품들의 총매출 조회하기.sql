SELECT P.product_id
    , P.product_name
    , SUM(O.amount * P.price) AS total_sales
FROM food_product P
    JOIN food_order O ON P.product_id = O.product_id
WHERE DATE_FORMAT(produce_date, '%Y-%m') = '2022-05'
GROUP BY P.product_id
ORDER BY total_sales DESC
    , P.product_id