SELECT B.category
    , SUM(BS.sales) AS total_sales
FROM book B
    JOIN book_sales BS ON B.book_id = BS.book_id
    AND BS.sales_date LIKE '2022-01%'
GROUP BY B.category
ORDER BY B.category;