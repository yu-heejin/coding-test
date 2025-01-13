SELECT I.animal_id
    , I.name
FROM animal_ins I
    JOIN animal_outs O ON I.animal_id = O.animal_id
        AND I.datetime > O.datetime
ORDER BY I.datetime
;