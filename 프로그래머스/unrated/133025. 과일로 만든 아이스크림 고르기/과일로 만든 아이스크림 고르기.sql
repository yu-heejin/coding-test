SELECT I.flavor
FROM icecream_info I
JOIN first_half F ON I.flavor = F.flavor
WHERE F.total_order > 3000 AND I.ingredient_type = 'fruit_based'
ORDER BY F.total_order DESC;