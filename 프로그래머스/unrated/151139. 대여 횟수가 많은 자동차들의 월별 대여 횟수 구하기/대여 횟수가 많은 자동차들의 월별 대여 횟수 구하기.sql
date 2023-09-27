SELECT
    MONTH(start_date) AS month
    , car_id
    , COUNT(car_id) AS records
FROM
    car_rental_company_rental_history
WHERE
    car_id IN (
    # 대여 시작일 기준 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차 리스트
    SELECT
        car_id
    FROM
        car_rental_company_rental_history
    WHERE
        YEAR(start_date) = 2022
        AND MONTH(start_date) BETWEEN 8 AND 10
    GROUP BY
        car_id
    HAVING
        COUNT(car_id) >= 5
    )
    AND YEAR(start_date) = 2022
    AND MONTH(start_date) BETWEEN 8 AND 10
GROUP BY
    month
    , car_id
ORDER BY
    month
    , car_id DESC
;