SELECT
    car_id
    , ROUND(AVG(DATEDIFF(end_date, start_date)), 1) + 1 AS average_duration
FROM
    car_rental_company_rental_history
GROUP BY
    car_id   -- id는 고유한 값
HAVING
    average_duration >= 7
ORDER BY
    average_duration DESC     -- DESC는 각각 붙여야한다.
    , car_id DESC
;