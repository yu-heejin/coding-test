SELECT I.item_id
    , I.item_name
FROM item_info I
    JOIN item_tree T ON I.item_id = T.item_id
WHERE T.parent_item_id IS NULL
ORDER BY I.item_id;