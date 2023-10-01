SELECT
    A.author_id
    , A.author_name
    , B.category
    , SUM(BS.sales * B.price) AS sales
FROM
    book_sales BS, author A, book B
WHERE
    BS.book_id = B.book_id
    AND B.author_id = A.author_id
    AND BS.sales_date LIKE '2022-01%'
GROUP BY
    A.author_id
    , A.author_name
    , B.category
ORDER BY
    A.author_id
    , B.category DESC
;