select ip_cliente , count(*) as quantitá_richieste
 FROM log_entity group by ip_cliente order by quantitá_richieste Desc