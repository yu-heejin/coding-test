-- 코드를 입력하세요
SELECT
    CONCAT(
        '/home/grep/src/',
         B.board_id,
        '/',
        F.file_id,
        F.file_name,
        F.file_ext
    ) AS file_path
FROM
    used_goods_file F
    JOIN used_goods_board B ON F.board_id = B.board_id
WHERE
    B.views = (
        SELECT
            MAX(views)
        FROM
            used_goods_board
    )
ORDER BY
    F.file_id DESC
;