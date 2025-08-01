SELECT COUNT(*) AS fish_count
FROM fish_info I
    JOIN fish_name_info N ON N.fish_type = I.fish_type
WHERE N.fish_name = 'SNAPPER' OR N.fish_name = 'BASS'
;