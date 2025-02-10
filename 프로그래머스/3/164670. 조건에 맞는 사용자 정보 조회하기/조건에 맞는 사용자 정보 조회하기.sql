SELECT U.user_id
    , U.nickname
    , CONCAT(U.city, ' ', U.street_address1, ' ', U.street_address2) AS 전체주소
    , CONCAT(SUBSTR(U.tlno, 1, 3), '-', SUBSTR(U.tlno, 4, 4), '-', SUBSTR(U.tlno, 8, 4)) AS 전화번호
FROM (
    SELECT writer_id
        , COUNT(*) AS board_count
    FROM used_goods_board
    GROUP BY writer_id
) T
    JOIN used_goods_user U ON T.writer_id = U.user_id
    AND T.board_count >= 3
ORDER BY U.user_id DESC;