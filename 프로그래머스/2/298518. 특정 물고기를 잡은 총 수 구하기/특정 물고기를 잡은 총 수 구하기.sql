SELECT COUNT(*) AS fish_count
FROM fish_info I
    JOIN fish_name_info N ON N.fish_type = I.fish_type
    AND (N.fish_name = 'SNAPPER' OR N.fish_name = 'BASS')  # 연산자 우선순위 때문에 괄호쳐야함
;