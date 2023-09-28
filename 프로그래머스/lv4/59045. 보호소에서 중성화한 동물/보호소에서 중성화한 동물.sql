-- 보호소 들어올 땐 중성화 안됐지만 나갈 땐 중성화 된 동물
SELECT
    AO.animal_id
    , AO.animal_type
    , AO.name
FROM
    animal_outs AO
    JOIN animal_ins AI ON AO.animal_id = AI.animal_id
WHERE
    (AO.sex_upon_outcome LIKE 'Spayed%' OR AO.sex_upon_outcome LIKE 'Neutered%')
    AND (AI.sex_upon_intake LIKE 'Intact%')
;
    