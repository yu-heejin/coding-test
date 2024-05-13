# 각 개체의 세대를 구하기 위한 Recursive CTE
WITH RECURSIVE generation_tb AS (
    # 초기값 - 1세대
    SELECT id
        , 1 AS gen
        , parent_id
    FROM ecoli_data
    WHERE parent_id IS NULL
    UNION
    # 재귀
    SELECT E.id
        , G.gen + 1
        , E.parent_id
    FROM generation_tb G
        LEFT JOIN ecoli_data E ON G.id = E.parent_id
    WHERE E.id IS NOT NULL    # 종료조건, 더이상 child_id가 존재하지 않을 경우 재귀를 탈출한다.
),
# 자식 개체 존재 여부 확인
child_tb AS (
    SELECT G1.id
        , G1.gen
        , G2.parent_id AS child_id
    FROM generation_tb G1
        LEFT JOIN generation_tb G2 ON G1.id = G2.parent_id
)

SELECT COUNT(DISTINCT(id)) AS count
    , gen AS generation
FROM child_tb
WHERE child_id IS NULL
GROUP BY gen
ORDER BY gen;