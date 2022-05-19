select 
	ip_cliente ,  count(*) as quantitá_richieste
 FROM 
	log_entity 
where 
	mese = 'Aug' and giorno = 25
group by ip_cliente order by quantitá_richieste Desc