-- 코드를 입력하세요
SELECT
    FH.FLAVOR
FROM
    FIRST_HALF AS FH
JOIN
    ICECREAM_INFO AS II
ON
    FH.FLAVOR = II.FLAVOR
WHERE
    FH.TOTAL_ORDER >= 3000
    AND
    II.INGREDIENT_TYPE = 'fruit_based'
ORDER BY
    FH.TOTAL_ORDER DESC
;