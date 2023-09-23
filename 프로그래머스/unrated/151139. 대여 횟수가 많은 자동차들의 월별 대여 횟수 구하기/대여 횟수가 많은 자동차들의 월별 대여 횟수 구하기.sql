SELECT
    MONTH(start_date) AS month
    , car_id
    , COUNT(*) AS records
FROM
    car_rental_company_rental_history
WHERE
    car_id IN (
        SELECT
            car_id
        FROM
            car_rental_company_rental_history
        WHERE
            DATE_FORMAT(start_date, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
        GROUP BY
            car_id
        HAVING
            COUNT(car_id) >= 5
    )
    AND DATE_FORMAT(start_date, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
GROUP BY
    month
    , car_id
HAVING
    records > 0
ORDER BY
    month
    , car_id DESC
;