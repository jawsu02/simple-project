SELECT COUNT(distinct lounge_set_source_lk.LOUNGE_SET_ID)
FROM
lounge_set ls
INNER JOIN lounge_set_lounge_lk ON lounge_set_lounge_lk.lounge_set_id = ls.lounge_set_id
INNER JOIN lounge_set_source_lk ON lounge_set_lounge_lk.lounge_set_id = lounge_set_source_lk.lounge_set_id
AND lounge_set_source_lk.valid_from <= GETDATE()
AND ( lounge_set_source_lk.valid_to >= GETDATE() OR lounge_set_source_lk.valid_to IS NULL )
INNER JOIN source_deal_config ON source_deal_config.source_deal_config_id = lounge_set_source_lk.source_deal_config_id
WHERE lounge_set_lounge_lk.isdeleted = 0 AND ls.product_code = 'LK' order by lounge_set_source_lk.lounge_set_id asc