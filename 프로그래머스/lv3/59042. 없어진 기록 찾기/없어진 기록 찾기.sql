SELECT
    AO.animal_id
    , AO.name
FROM
    animal_outs AO
    LEFT JOIN animal_ins AI ON AO.animal_id = AI.animal_id
WHERE
    AI.animal_id IS NULL
;