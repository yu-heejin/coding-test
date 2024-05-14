WITH RECURSIVE generation_tb AS (
    # 초기값 - 1세대
    SELECT id
        , 1 AS generation
    FROM ecoli_data
    WHERE parent_id IS NULL
    UNION
    SELECT E.id
        , generation + 1
    FROM generation_tb G
        LEFT JOIN ecoli_data E ON G.id = E.parent_id    # 자식이 없는 개체를 위해 left join
    WHERE E.id IS NOT NULL   # 더 이상 자식 개체의 값이 존재하지 않으면 재귀 종료
)

SELECT id
FROM generation_tb
WHERE generation = 3;