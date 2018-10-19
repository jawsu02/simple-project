SELECT
      count(*) AS LOUNGES_COUNT
   FROM lounge
   LEFT OUTER JOIN lounge_lang ON lounge.lounge_code = lounge_lang.lounge_code
    AND lounge_lang.language_code = 'en'
   INNER JOIN lounge_product ON lounge.lounge_code = lounge_product.lounge_code
    AND lounge_product.lounge_status = 'A'
    AND lounge_product.product_code = 'PARAM1'
    AND lounge.lounge_code='PARAM2'
   INNER JOIN airport ON airport.iso_airport_code = lounge.airport
   INNER JOIN code AS country ON LEFT(country.code,3) = lounge.country_code
    AND country.codetype = 'CTRY'