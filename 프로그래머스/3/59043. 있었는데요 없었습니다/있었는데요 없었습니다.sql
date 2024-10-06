SELECT O.animal_id
    , O.name
FROM animal_ins I
    JOIN animal_outs O ON I.animal_id = O.animal_id
WHERE I.datetime > O.datetime
ORDER BY I.datetime;