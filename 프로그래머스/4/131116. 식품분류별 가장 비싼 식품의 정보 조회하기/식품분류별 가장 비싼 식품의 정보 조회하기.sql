# 각 카테고리 별 가격 랭킹
WITH max_price_per_category AS (
    SELECT category
        , product_name
        , price
        , ROW_NUMBER() OVER (PARTITION BY category ORDER BY price DESC) AS ranking
    FROM food_product
)

SELECT category
    , price AS max_price
    , product_name
FROM max_price_per_category
WHERE ranking = 1
    AND category IN ('과자', '국', '김치', '식용유')
ORDER BY max_price DESC;