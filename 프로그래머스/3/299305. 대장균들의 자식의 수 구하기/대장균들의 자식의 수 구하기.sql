# 각 부모 아이디 별 그룹

SELECT id
    , IFNULL(child_count, 0) AS child_count
FROM ecoli_data E
    LEFT JOIN (
        SELECT parent_id
            , COUNT(*) AS child_count
        FROM ecoli_data
        GROUP BY parent_id
        HAVING parent_id IS NOT NULL
    ) C ON E.id = C.parent_id
;