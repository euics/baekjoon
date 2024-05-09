-- 코드를 작성해주세요
SELECT
    FI.ID,
    FNI.FISH_NAME,
    FI.LENGTH
FROM
    FISH_INFO FI
JOIN
    FISH_NAME_INFO FNI
    ON
    FI.FISH_TYPE = FNI.FISH_TYPE
WHERE
    FI.LENGTH = (SELECT
                    MAX(LENGTH)
                FROM
                    FISH_INFO
                WHERE
                    FISH_TYPE = FI.FISH_TYPE 
                    AND 
                    LENGTH IS NOT NULL)
ORDER BY
    FI.ID ASC
;