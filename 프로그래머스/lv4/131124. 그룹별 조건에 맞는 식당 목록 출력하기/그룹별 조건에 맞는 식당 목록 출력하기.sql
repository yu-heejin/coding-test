SELECT
    MP.member_name
    , R.review_text
    , DATE_FORMAT(R.review_date, '%Y-%m-%d') AS review_date
FROM
    rest_review R
    JOIN member_profile MP ON R.member_id = MP.member_id
WHERE
    MP.member_id = (
        SELECT member_id
        FROM rest_review
        GROUP BY member_id
        ORDER BY COUNT(member_id) DESC
        LIMIT 1
    )
ORDER BY
    R.review_date
    , R.review_text
;