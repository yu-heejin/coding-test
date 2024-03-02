# 자동차 종류가 세단, SUV인 자동차 중 11월에 대여 가능한 자동차
# 11월에 대여 가능하려면 11월 1일 ~ 30일 사이에 기록이 없어야한다
WITH sedan_suv_car AS (
    SELECT DISTINCT C.car_id
        , C.car_type
        , C.daily_fee
        , C.options
    FROM car_rental_company_car C
        LEFT JOIN car_rental_company_rental_history H ON C.car_id = H.car_id
    WHERE (C.car_type = '세단' OR C.car_type = 'SUV')
        AND C.car_id NOT IN (
            SELECT car_id
            FROM car_rental_company_rental_history
            WHERE start_date >= '2022-11-01'
                OR end_date >= '2022-11-01'
        )
),
# 30일간의 대여 금액
month_rental_fee AS (
    SELECT C.car_id
        , C.car_type
        , ROUND(C.daily_fee * (1 - P.discount_rate / 100)) * 30 AS fee
    FROM sedan_suv_car C
        JOIN car_rental_company_discount_plan P ON C.car_type = P.car_type
            AND P.duration_type = '30일 이상'
)

SELECT *
FROM month_rental_fee
WHERE fee >= 500000
    AND fee < 2000000
ORDER BY fee DESC
    , C.car_type
    , C.car_id DESC
;