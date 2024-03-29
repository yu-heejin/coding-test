# 2021년에 가입한 전체 회원
WITH join_2021_user AS (
    SELECT user_id
    FROM user_info
    WHERE YEAR(joined) = '2021'
)

# 사용자의 수를 카운팅하기 때문에 DISTINCT를 붙여야 정확한 결과가 나온다. (구매 횟수 X)
SELECT YEAR(O.sales_date) AS year
    , MONTH(O.sales_date) AS month
    , COUNT(DISTINCT O.user_id) AS puchased_users
    , ROUND(COUNT(DISTINCT O.user_id) / (SELECT COUNT(*) FROM join_2021_user), 1) AS puchased_ratio
FROM online_sale O
    JOIN join_2021_user J ON O.user_id = J.user_id
GROUP BY year
    , month
;