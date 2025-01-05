# 각 직원의 평균 점수 및 등급
WITH hr_grade_avg AS (
    SELECT emp_no 
        , AVG(score) AS avg_score
        , CASE WHEN AVG(score) >= 96 THEN 'S'
            WHEN AVG(score) >= 90 THEN 'A'
            WHEN AVG(score) >= 80 THEN 'B'
            ELSE 'C'
        END AS grade
    FROM hr_grade
    GROUP BY emp_no
)

SELECT E.emp_no
    , E.emp_name
    , G.grade
    , CASE WHEN G.grade = 'S' THEN E.sal * (20 / 100)
        WHEN G.grade = 'A' THEN E.sal * (15 / 100)
        WHEN G.grade = 'B' THEN E.sal * (10 / 100)
        ELSE 0
    END AS bonus
FROM hr_grade_avg G
    JOIN hr_employees E ON G.emp_no = E.emp_no
ORDER BY E.emp_no;