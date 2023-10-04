WITH products AS (
    SELECT cart_id
        , GROUP_CONCAT(name) AS name
    FROM cart_products
    GROUP BY cart_id
)

SELECT cart_id
FROM products
WHERE name LIKE '%Milk%' AND name LIKE '%Yogurt%'
;