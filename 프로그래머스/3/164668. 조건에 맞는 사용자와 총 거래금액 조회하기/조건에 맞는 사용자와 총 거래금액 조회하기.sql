SELECT user_id
    , nickname
    , total_sales
FROM (
    SELECT U.user_id
        , U.nickname
        , SUM(B.price) AS total_sales
    FROM used_goods_board B
        JOIN used_goods_user U ON B.writer_id = U.user_id
    WHERE B.status = 'DONE'
    GROUP BY U.user_id
) T
WHERE total_sales >= 700000
ORDER BY total_sales;