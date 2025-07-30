# 아이템 희귀도가 RARE인 아이템들의 자식 아이템
SELECT I.item_id
    , item_name
    , rarity
FROM item_info I
    JOIN item_tree T ON I.item_id = T.item_id
WHERE parent_item_id IN (
    # RARE인 부모 아이템 찾기
    SELECT item_id
    FROM item_info
    WHERE rarity = 'RARE'
)
ORDER BY item_id DESC;