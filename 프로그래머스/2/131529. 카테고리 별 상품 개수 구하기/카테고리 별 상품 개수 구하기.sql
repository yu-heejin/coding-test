SELECT LEFT(product_code, 2) AS category
    , COUNT(*) AS products
FROM product
GROUP BY LEFT(product_code, 2)
ORDER BY category;

#SELECT category
#    , COUNT(category) AS products
#FROM (
#    SELECT LEFT(product_code, 2) AS category
#    FROM product
#) R
#GROUP BY category
#ORDER BY category;Add comment