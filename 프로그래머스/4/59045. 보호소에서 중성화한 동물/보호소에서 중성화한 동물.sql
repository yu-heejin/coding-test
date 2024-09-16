SELECT AO.animal_id
    , AO.animal_type
    , AO.name
FROM animal_ins AI
    JOIN animal_outs AO ON AI.animal_id = AO.animal_id
WHERE AI.sex_upon_intake LIKE '%Intact%'
    AND (AO.sex_upon_outcome LIKE '%Spayed%'
    OR AO.sex_upon_outcome LIKE '%Neutered%')
ORDER BY AO.animal_id
;