# 조회수가 가장 높은 게시물은 하나만 존재한다.
SELECT CONCAT('/home/grep/src/', board_id, '/', file_id, file_name, file_ext) AS file_path
FROM used_goods_file
WHERE board_id = (
    SELECT board_id
    FROM used_goods_board
    ORDER BY views DESC
    LIMIT 1
)
ORDER BY file_id DESC;