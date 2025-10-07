SELECT O.animal_id
    , O.name
FROM animal_ins I
    RIGHT JOIN animal_outs O ON I.animal_id = O.animal_id
WHERE I.animal_id IS NULL
ORDER BY O.animal_id;