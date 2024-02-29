# 타입이 트럭인 자동차들의 대여 기간
WITH car_date_and_discount AS (
    SELECT H.history_id
        , H.car_id
        , C.car_type
        , C.daily_fee
        , DATEDIFF(end_date, start_date) + 1 AS duration
        , CASE 
            WHEN DATEDIFF(end_date, start_date) + 1 >= 7 AND DATEDIFF(end_date, start_date) + 1 < 30 THEN '7일 이상'
            WHEN DATEDIFF(end_date, start_date) + 1 >= 30 AND DATEDIFF(end_date, start_date) + 1 < 90 THEN '30일 이상'
            WHEN DATEDIFF(end_date, start_date) + 1 >= 90 THEN '90일 이상'
            ELSE null
        END AS period
    FROM car_rental_company_rental_history H
        JOIN car_rental_company_car C ON H.car_id = C.car_id
    WHERE C.car_type = '트럭'
)

SELECT D.history_id
    , ROUND((D.daily_fee - (D.daily_fee * (IFNULL(P.discount_rate, 0) / 100))) * D.duration) AS fee
FROM car_date_and_discount D
    LEFT JOIN car_rental_company_discount_plan P ON D.car_type = P.car_type
        AND D.period = P.duration_type
ORDER BY fee DESC
    , history_id DESC
;