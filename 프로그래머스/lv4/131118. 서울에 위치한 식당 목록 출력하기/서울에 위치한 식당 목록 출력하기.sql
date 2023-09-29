SELECT
    RV.rest_id
    , RI.rest_name
    , RI.food_type
    , RI.favorites
    , RI.address
    , ROUND(AVG(review_score), 2) AS score
FROM
    rest_review RV
    JOIN rest_info RI ON RV.rest_id = RI.rest_id
WHERE
    RI.address LIKE '서울%'
GROUP BY
    RV.rest_id
ORDER BY
    score DESC
    , RI.favorites DESC
;