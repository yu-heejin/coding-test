# & 연산자: 대응되는 bit가 모두 1이면 1을 반환한다.
SELECT DISTINCT D.id
    , D.email
    , D.first_name
    , D.last_name
FROM developers D
    JOIN skillcodes S ON S.code & D.skill_code = S.code
    AND S.category = 'Front End'
ORDER BY id
;