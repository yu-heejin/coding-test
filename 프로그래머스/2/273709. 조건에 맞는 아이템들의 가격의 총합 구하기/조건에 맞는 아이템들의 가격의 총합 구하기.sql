SELECT SUM(price) AS total_price
FROM item_info
GROUP BY rarity
HAVING rarity = 'LEGEND';