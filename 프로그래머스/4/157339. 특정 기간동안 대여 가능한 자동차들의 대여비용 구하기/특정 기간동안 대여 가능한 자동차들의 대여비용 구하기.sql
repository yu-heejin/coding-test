# 11월 대여 가능 조건
# 1. 대여 시작 날짜가 11월 1일 이전
# 2. 대여 종료 날짜가 11월 1일 이전
# 3. 대여 시작 날짜가 없는 경우
# 기록은 여러개이며, 이 중 11월 이후 기록이 있는 아이디를 제거

SELECT C.car_id
    , C.car_type
    , ROUND(C.daily_fee * (1 - D.discount_rate / 100) * 30) AS fee
FROM car_rental_company_car C
    JOIN (
        SELECT duration_type
            , car_type
            , discount_rate
        FROM car_rental_company_discount_plan
        WHERE duration_type = '30일 이상'
            AND (car_type = '세단' OR car_type = 'SUV')
    ) D ON D.car_type = C.car_type
WHERE C.car_id NOT IN (
    SELECT C.car_id
    FROM car_rental_company_rental_history H
        RIGHT OUTER JOIN car_rental_company_car C ON H.car_id = C.car_id
    WHERE H.start_date >= '2022-11-01' OR H.end_date >= '2022-11-01'
)
    AND (C.car_type = '세단' OR C.car_type = 'SUV')
    AND C.daily_fee * (1 - D.discount_rate / 100) * 30 BETWEEN 500000 AND 2000001
ORDER BY fee DESC
    , C.car_type
    , C.car_id DESC
;