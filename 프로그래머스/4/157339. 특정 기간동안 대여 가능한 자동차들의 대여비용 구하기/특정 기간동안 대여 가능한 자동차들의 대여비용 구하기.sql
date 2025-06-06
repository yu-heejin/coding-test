# 11월 1일 ~ 11월 30일까지 대여 가능한 세단, SUV
# 대여 가능 조건: 대여 기록이 없음, 11/1 ~ 11/30까지 대여 기록 없음
WITH available_car AS (
    SELECT DISTINCT C.car_id
        , C.car_type
        , C.daily_fee
    FROM car_rental_company_car C
        # 기록이 없어도 대여 가능하려면 LEFT JOIN
        LEFT JOIN car_rental_company_rental_history H ON C.car_id = H.car_id
    WHERE C.car_type IN ('세단', 'SUV')
        # AND C.car_id NOT IN (
        #     SELECT car_id
        #     FROM car_rental_company_rental_history
        #     WHERE (start_date >= '2022-11-01' OR start_date <= '2022-11-30')
        #         AND (end_date >= '2022-11-01' OR end_date <= '2022-11-30')
        # )
        AND C.car_id NOT IN (
            SELECT car_id
            FROM car_rental_company_rental_history
            WHERE start_date >= '2022-11-01'
                OR end_date >= '2022-11-01'
        )
),
# 30일간의 대여 금액 (할인 포함)
total_rental_cost AS (
SELECT A.car_id
    , A.car_type
    , ROUND(A.daily_fee * (1 - P.discount_rate / 100) * 30) AS fee
FROM available_car A
    JOIN car_rental_company_discount_plan P ON A.car_type = P.car_type
    AND P.duration_type = '30일 이상'
)

SELECT *
FROM total_rental_cost
WHERE fee >= 500000
    AND fee < 2000000
ORDER BY fee DESC
    , car_type
    , car_id DESC
;