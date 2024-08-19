SELECT DISTINCT R.car_id
FROM car_rental_company_car R
    JOIN car_rental_company_rental_history H 
        ON R.car_id = H.car_id
        AND car_type = '세단'
WHERE MONTH(H.start_date) = 10
ORDER BY R.car_id DESC;

