SELECT
     count(*) AS AIRPORT_COUNT
   FROM
    code country
    INNER JOIN code country2 ON country.code = country2.code
            AND country2.codetype = 'CTRY2'
            AND country2.alpha_1 <> ''
            AND country2.alpha_5 <> ''
    INNER JOIN currency ON currency.pp_code = CASE WHEN LTRIM(RTRIM(country2.alpha_2)) = '' THEN 'US' ELSE ISNULL( country2.alpha_2, 'US' ) END
    LEFT OUTER JOIN code schengen ON country.code = schengen.code
            AND schengen.codetype = 'SCHENGEN'
   WHERE
     country.code NOT IN ('CLI','ENG','IOM','NIR','SCO','WAL')
    AND country.codetype ='CTRY'