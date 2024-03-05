# 멤버별 리뷰 카운팅
WITH review_count AS (
    SELECT M.member_id
        , M.member_name
        , COUNT(*) AS review_count_per_member
    FROM rest_review R
        JOIN member_profile M ON R.member_id = M.member_id
    GROUP BY M.member_id
)

SELECT C.member_name
    , R.review_text
    , DATE_FORMAT(R.review_date, '%Y-%m-%d') AS review_date
FROM review_count C
    JOIN rest_review R ON C.member_id = R.member_id
WHERE review_count_per_member = (
    SELECT MAX(review_count_per_member)
    FROM review_count
)
ORDER BY R.review_date
    , R.review_text
;