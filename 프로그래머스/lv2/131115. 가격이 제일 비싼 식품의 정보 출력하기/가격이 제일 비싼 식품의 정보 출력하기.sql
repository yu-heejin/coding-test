SELECT
	*
FROM
	food_product
WHERE price = (
	SELECT
		MAX(price)
	FROM
		food_product
)
;