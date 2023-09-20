SELECT
    B.category
    , SUM(BS.sales) AS total_sales
FROM
    book_sales BS
    JOIN book B ON BS.book_id = B.book_id
WHERE
    BS.sales_date LIKE '2022-01%'
GROUP BY
    B.category
ORDER BY
    B.category
;