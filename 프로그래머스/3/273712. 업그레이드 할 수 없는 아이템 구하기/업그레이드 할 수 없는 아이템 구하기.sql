# 누군가의 parent item이 아닌 아이템 찾기
WITH not_parent_item AS (
    SELECT item_id
    FROM item_tree
    WHERE item_id NOT IN (
        SELECT parent_item_id
        FROM item_tree
        WHERE parent_item_id IS NOT NULL
    )
)

SELECT I.item_id
    , I.item_name
    , I.rarity
FROM not_parent_item N
    JOIN item_info I ON N.item_id = I.item_id
ORDER BY I.item_id DESC
;