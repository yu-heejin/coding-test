SELECT YEAR(O.sales_date) AS year
    , MONTH(O.sales_date) AS month
    , U.gender
    , COUNT(DISTINCT U.user_id) AS users
FROM
    online_sale O
    JOIN user_info U ON O.user_id = U.user_id
WHERE
    U.gender IS NOT NULL
GROUP BY YEAR(O.sales_date)
    , MONTH(O.sales_date)
    , U.gender
ORDER BY year
    , month
    , U.gender
;