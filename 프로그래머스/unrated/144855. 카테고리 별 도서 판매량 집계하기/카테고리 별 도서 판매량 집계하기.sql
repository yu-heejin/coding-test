SELECT
    BOOK.category
    , SUM(SALES.sales) AS total_sales
FROM
    book_sales SALES
    JOIN book BOOK ON SALES.book_id = BOOK.book_id
WHERE
    SALES.sales_date LIKE '2022-01%'
GROUP BY
    BOOK.category
ORDER BY
    BOOK.category
;