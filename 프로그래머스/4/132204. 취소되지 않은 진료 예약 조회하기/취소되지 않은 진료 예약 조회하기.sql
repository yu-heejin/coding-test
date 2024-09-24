SELECT A.apnt_no
    , P.pt_name
    , P.pt_no
    , A.mcdp_cd
    , D.dr_name
    , A.apnt_ymd
FROM appointment A
    JOIN patient P ON A.pt_no = P.pt_no
    JOIN doctor D ON A.mddr_id = D.dr_id
WHERE A.apnt_ymd LIKE '2022-04-13%'
    AND A.apnt_cncl_yn = 'N'
ORDER BY A.apnt_ymd
;