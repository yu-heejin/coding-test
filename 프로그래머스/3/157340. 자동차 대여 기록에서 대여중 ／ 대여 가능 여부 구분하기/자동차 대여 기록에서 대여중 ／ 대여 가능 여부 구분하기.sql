# 아래 결과에서 하나라도 대여 불가능인 경우 대여 불가능으로 간주
# 대여 불가능 1 대여 가능 0, 1이 하나라도 나오면 대여 불가능으로 판단
SELECT car_id
    , CASE WHEN
        MAX(availability) = 1 THEN '대여중'
        ELSE '대여 가능'
    END AS availability
FROM (
    SELECT car_id
        , IF('2022-10-16' BETWEEN start_date AND end_date, 1, 0) AS availability
    FROM car_rental_company_rental_history
) R
GROUP BY car_id
ORDER BY car_id DESC;