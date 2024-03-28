# 각 물고기의 평균 길이
WITH average_fish_length AS (
    SELECT fish_type
        , AVG(length) AS average_length
        , COUNT(*) AS fish_count
    FROM (
        SELECT id
            , fish_type
            , IFNULL(length, 10) AS length
            , time
        FROM fish_info
    ) F
    GROUP BY fish_type
),
# 각 물고기의 최대 길이
max_fish_length AS (
    SELECT fish_type
        , MAX(length) AS max_length
    FROM fish_info
    GROUP BY fish_type
)

SELECT A.fish_count
    , M.max_length
    , A.fish_type
FROM max_fish_length M
    JOIN average_fish_length A ON M.fish_type = A.fish_type 
WHERE average_length >= 33
ORDER BY fish_type;