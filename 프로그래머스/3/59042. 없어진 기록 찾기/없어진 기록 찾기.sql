SELECT AO.animal_id
    , AO.name
FROM animal_ins AI
    RIGHT JOIN animal_outs AO ON AI.animal_id = AO.animal_id
WHERE AI.animal_id IS NULL
ORDER BY AO.animal_id
;