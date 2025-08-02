# 연도별 가장 큰 대장균 크기
WITH max_size_of_colony AS (
    SELECT YEAR(differentiation_date) AS year
        , MAX(size_of_colony) AS max_size_of_colony
    FROM ecoli_data
    GROUP BY year
),
# 연도별 대장균 (*이 먼저 와야함)
year_ecoli_data AS (
    SELECT *
        , YEAR(differentiation_date) AS year
    FROM ecoli_data
)

SELECT E.year
    , max_size_of_colony - size_of_colony AS year_dev
    , E.id
FROM year_ecoli_data E
    JOIN max_size_of_colony C ON E.year = C.year
ORDER BY year
    , year_dev
;