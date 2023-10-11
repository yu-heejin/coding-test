SELECT A.apnt_no
    , P.pt_name
    , P.pt_no
    , A.mcdp_cd
    , D.dr_name
    , A.apnt_ymd
FROM appointment A
    JOIN patient P ON P.pt_no = A.pt_no
    JOIN doctor D ON D.dr_id = A.mddr_id
WHERE A.mcdp_cd = 'CS'
    AND A.apnt_cncl_yn = 'N'
    AND DATE_FORMAT( A.apnt_ymd, '%Y-%m-%d') = '2022-04-13'
ORDER BY A.apnt_ymd
;