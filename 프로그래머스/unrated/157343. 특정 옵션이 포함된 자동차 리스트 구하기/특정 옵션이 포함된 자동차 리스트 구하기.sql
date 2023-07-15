SELECT *
FROM car_rental_company_car
WHERE LOCATE('네비게이션', options)
ORDER BY car_id DESC;