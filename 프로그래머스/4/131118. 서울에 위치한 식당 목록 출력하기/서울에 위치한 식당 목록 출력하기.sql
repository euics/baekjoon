-- 코드를 입력하세요
SELECT
    RI.REST_ID,
    RI.REST_NAME,
    RI.FOOD_TYPE,
    RI.FAVORITES,
    RI.ADDRESS,
    ROUND(AVG(RR.REVIEW_SCORE), 2) AS SCORE
FROM
    REST_INFO AS RI
JOIN
    REST_REVIEW AS RR
ON
    RI.REST_ID = RR.REST_ID
WHERE
    RI.ADDRESS LIKE '서울%'
GROUP BY
    RR.REST_ID
ORDER BY
    AVG(RR.REVIEW_SCORE) DESC,
    RI.FAVORITES DESC
;