# 종류별 가장 큰 물고기 길이
WITH max_fish_length AS (
    SELECT fish_type
        , MAX(length) AS length
    FROM fish_info
    GROUP BY fish_type
)

SELECT I.id
    , N.fish_name
    , M.length
FROM fish_info I
    JOIN max_fish_length M ON I.length = M.length
        AND I.fish_type = M.fish_type
    JOIN fish_name_info N ON N.fish_type = I.fish_type
;
