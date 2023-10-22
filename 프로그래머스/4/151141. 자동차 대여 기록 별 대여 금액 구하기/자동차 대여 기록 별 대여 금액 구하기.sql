# IN 절에는 WITH절을 사용할 수 없다.
# 하나의 히스토리에 하나의 할인 정책이 붙어야함
WITH truck_car AS (
    SELECT C.car_id
        , H.history_id
        , C.car_type
        , C.daily_fee
        , DATEDIFF(H.end_date, H.start_date) + 1 AS duration
    FROM car_rental_company_rental_history H
        JOIN car_rental_company_car C ON H.car_id = C.car_id
    WHERE C.car_type = '트럭'
)

SELECT T.history_id
    , ROUND(T.daily_fee * (1 - IFNULL(P.discount_rate, 0) / 100) * T.duration) AS fee
FROM truck_car T
    LEFT JOIN car_rental_company_discount_plan P ON T.car_type = P.car_type
        AND P.duration_type = 
            CASE 
                WHEN T.duration >= 90 THEN '90일 이상'
                WHEN T.duration >= 30 THEN '30일 이상'
                WHEN T.duration >= 7 THEN '7일 이상'
                ELSE null
            END
ORDER BY fee DESC
    , T.history_id DESC

;