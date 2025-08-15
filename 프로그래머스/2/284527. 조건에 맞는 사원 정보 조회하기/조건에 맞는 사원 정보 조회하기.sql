# 각 분기별 합
WITH hr_total_grade AS (
    SELECT SUM(score) AS total_score
        , emp_no
    FROM hr_grade
    GROUP BY emp_no
)

SELECT G.total_score AS score
    , E.emp_no
    , E.emp_name
    , E.position
    , E.email
FROM hr_employees E
    JOIN hr_total_grade G ON E.emp_no = G.emp_no
WHERE G.total_score IN (
    SELECT MAX(total_score)
    FROM hr_total_grade
);