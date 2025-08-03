SELECT R.food_type
    , R.rest_id
    , R.rest_name
    , R.favorites
FROM rest_info R
    JOIN (
        SELECT food_type
            , MAX(favorites) AS favorites
        FROM rest_info
        GROUP BY food_type
    ) I ON R.favorites = I.favorites
    AND R.food_type = I.food_type
ORDER BY food_type DESC;