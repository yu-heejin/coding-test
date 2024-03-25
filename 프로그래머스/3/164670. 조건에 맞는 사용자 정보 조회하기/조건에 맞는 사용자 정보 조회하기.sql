# 게시물 작성 횟수
WITH board_count AS (
    SELECT writer_id
        , COUNT(*) AS board_cnt
    FROM used_goods_board U
    GROUP BY writer_id
)

# substr(문자열, 시작 위치, 가져올 길이)
SELECT U.user_id
    , U.nickname
    , CONCAT(U.city, ' ', U.street_address1, ' ', U.street_address2) AS '전체주소'
    , CONCAT(SUBSTR(U.tlno, 1, 3), '-', SUBSTR(U.tlno, 4, 4), '-', SUBSTR(U.tlno, 8, 4)) AS '전화번호'
FROM board_count B
    JOIN used_goods_user U ON B.writer_id = U.user_id
WHERE board_cnt >= 3
ORDER BY U.user_id DESC
;