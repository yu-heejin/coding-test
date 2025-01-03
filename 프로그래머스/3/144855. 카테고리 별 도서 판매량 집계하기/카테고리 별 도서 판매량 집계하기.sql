SELECT category
    , SUM(sales) AS total_sales
FROM book B
    JOIN book_sales S ON B.book_id = S.book_id
WHERE sales_date LIKE '2022-01%'
GROUP BY category
ORDER BY category;