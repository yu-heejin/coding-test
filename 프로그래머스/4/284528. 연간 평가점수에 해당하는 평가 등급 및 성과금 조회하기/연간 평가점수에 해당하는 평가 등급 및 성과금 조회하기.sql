# 각 사원별 평균 평가 점수
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
    , CASE G.grade WHEN 'S' THEN sal * (20 / 100) 
        WHEN 'A' THEN sal * (15 / 100) 
        WHEN 'B' THEN sal * (10 / 100)
        ELSE 0
     END AS bonus
FROM hr_employees E
    JOIN hr_grade_avg G ON E.emp_no = G.emp_no
ORDER BY E.emp_no
;