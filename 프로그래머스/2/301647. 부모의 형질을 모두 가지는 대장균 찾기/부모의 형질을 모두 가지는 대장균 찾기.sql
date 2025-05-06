SELECT E2.id
    , E2.genotype
    , E1.genotype AS parent_genotype
FROM ecoli_data E1
    JOIN ecoli_data E2 ON E1.id = E2.parent_id
    AND E1.genotype & E2.genotype = E1.genotype  # 이진수로 변환했을 때 부모의 형질을 갖고있는 경우
ORDER BY E2.id
;