SELECT CASE WHEN SUM(S.name = 'Python') > 0 AND SUM(S.category = 'Front End') > 0 THEN 'A'
    WHEN SUM(S.name = 'C#') > 0 THEN 'B'
    WHEN SUM(S.category = 'Front End') > 0 THEN 'C'
    END AS grade
    , D.id
    , D.email
FROM developers D
    JOIN skillcodes S ON D.skill_code & S.code > 0
GROUP BY D.id
    , D.email
HAVING grade IS NOT NULL
ORDER BY grade
    , id;