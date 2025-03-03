SELECT B.category
    , SUM(BS.sales) AS total_sales  # 카테고리별 판매량 '합산'
FROM book B
    JOIN book_sales BS ON B.book_id = BS.book_id
WHERE BS.sales_date LIKE '2022-01%'
GROUP BY B.category
ORDER BY B.category;