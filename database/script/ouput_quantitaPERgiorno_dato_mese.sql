select 
	giorno ,  count(*) as quantitá_richieste
 FROM 
	log_entity 
where 
	mese = 'Aug' 
group by giorno order by quantitá_richieste Desc