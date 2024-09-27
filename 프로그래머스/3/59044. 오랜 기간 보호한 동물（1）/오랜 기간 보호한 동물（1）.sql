# 아직 입양 못 간 동물 테이블
WITH not_out AS (
    SELECT I.name
        , I.datetime
    FROM animal_ins I
        LEFT JOIN animal_outs O ON I.animal_id = O.animal_id
    WHERE O.animal_id IS NULL
)

SELECT *
FROM not_out
ORDER BY datetime
LIMIT 3;