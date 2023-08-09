SELECT
    animal_type
    , COUNT(*)
FROM
    animal_ins
GROUP BY
    animal_type
ORDER BY
    animal_type
;