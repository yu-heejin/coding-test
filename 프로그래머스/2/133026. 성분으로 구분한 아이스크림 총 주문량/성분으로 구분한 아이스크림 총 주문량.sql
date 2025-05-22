SELECT I.ingredient_type
    , SUM(F.total_order) AS total_order
FROM icecream_info I
    JOIN first_half F ON I.flavor = F.flavor
GROUP BY I.ingredient_type
ORDER BY total_order
;