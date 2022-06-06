package unimore.t4.Heimdall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unimore.t4.Heimdall.model.LogEntity;

import java.util.List;


/**
 * Interfaccia che estende la JpaRepository per poter lavorare con il database
 */
public interface LogRepo extends JpaRepository<LogEntity, Long> {




    /**
     * Funzione che prende dal nostro intero database , i vari ip dei clienti richiedednti e ne calcola le richieste fatte da sempre
     * @return Lista contentenente liste di stringhe che rappresentano i log per i criteri scelti
     */
    @Query(
            value = "select ip_cliente , count(*) as quantita,  latitudine , longitudine  from log_entity group by ip_cliente , latitudine , longitudine order by quantita desc" ,
            nativeQuery = true
    )
    List<List<String>> findspammerglobal();

    /**
     * FUNZIONE che ragruppa in base al ip cliente , mese , giorno , anno le richieste di un certo ip
     * @return
     */
    @Query(
            value = "select ip_cliente , mese , giorno , anno, count(*) as quantita from log_entity group by ip_cliente , mese , anno , giorno  " ,
            nativeQuery = true
    )
    List<List<String>> findspammerMonthdayYear();

    /**
     * FUNZIONE CHE prende dal nostro database i log  e la quantita di log creati da una persona dati i seguenti parametri
     * @param mese_da_cercare  mese che vogliamo analizzare
     * @param giorno_cercato giorno che vogliamo analizzare
     * @param anno_da_cercare  anno che vogliamo analizzare
     * @return
     */

    @Query(
            value = "select ip_cliente , mese , giorno , anno, count(*) as quantita from log_entity  where mese = :mesex and giorno = :giornox and anno = :annox group by ip_cliente  " ,
            nativeQuery = true
    )
    List<List<String>> findspammerMonthdayYearvar( @Param("mesex") String mese_da_cercare , @Param("giornox") String giorno_cercato ,  @Param("annox") String anno_da_cercare);

    /**
     * FUNZIONE che prende dal nostro database i log e la quantita di log creati da una persona dati i seguenti parametri
     * @param mese_da_cercare  mese da cercare
     * @param anno_da_cercare anno da cercare
     * @return
     */
    @Query(
            value = "select ip_cliente , mese , giorno , anno, count(*) as quantita from log_entity  where mese = :mesex and anno = :annox group by ip_cliente  " ,
            nativeQuery = true
    )
    List<List<String>> findspammerMonthYearvar( @Param("mesex") String mese_da_cercare ,  @Param("annox") String anno_da_cercare);


    /**
     * FUNZIONE che prende dal nostro intero database tutti i log che abbiamo
     * @return Lista contentenente liste di stringhe che rappresentano i log per i criteri scelti
     */
    @Query(
            value = "Select giorno , mese , anno , orario , timezone , ip_cliente , autentificato , identificativo , dispositivo , sito_referente , richiesta ,  codice_risposta , qunatita_trasmissione from log_entity " ,
            nativeQuery = true
    )List<List<String>> findlog();

    /**
     * Funzione che fa una quarrie nel database dei seguenti dati id , data_completa , orario , qunatita_trasmissione, ip_cliente , richiesta , codice_risposta , tipo_richiesta
     * @return Lista di stringhe contenenti le occurrence
     */
    @Query(
            value = "select  id , data_completa , orario , qunatita_trasmissione, ip_cliente , richiesta , codice_risposta , tipo_richiesta from log_entity " ,
            nativeQuery = true
    )List<List<String>> findsmartlog();

    /**
     * Funzione che fa una quarrie nel database dei seguenti dati id , giorno , data_completa , timezone , mese , orario , anno , dispositivo , autentificato , qunatita_trasmissione  , ip_cliente , identificativo , posizione_Citta , latitudine , longitudine , posizione_stato ,  sito_referente , richiesta , codice_risposta , tipo_richiesta , valutazione
     * @return Lista di stringhe contenenti le occurrence
     */
    @Query(
            value = " Select id , giorno , data_completa , timezone , mese , orario , anno , dispositivo , autentificato , qunatita_trasmissione  , ip_cliente , identificativo , posizione_Citta , latitudine , longitudine , posizione_stato ,  sito_referente , richiesta , codice_risposta , tipo_richiesta , valutazione from log_entity " ,
            nativeQuery = true
    )List<List<String>> findalllogsuper();
    /**
     * FUNZIONE che prende dal nostro intero database tutti i log che abbiamo in un determinato mese o anno
     * @param mese_da_cercare  indica il mese
     * @param anno_da_cercare  indica l'anno
     * @return Lista contentenente liste di stringhe che rappresentano i log per i criteri scelti
     */
    @Query(
            value = "Select giorno , mese , anno , orario , timezone , ip_cliente , autentificato , identificativo , dispositivo , sito_referente , richiesta ,  codice_risposta , qunatita_trasmissione from log_entity where mese = :mesex and anno = :annox " ,
            nativeQuery = true
    )List<List<String>> findlogMonth(@Param("mesex") String mese_da_cercare , @Param("annox") String anno_da_cercare );

    /**
     * Funzione che fa una quarrie nel database dei seguenti dati giorno , mese , anno , orario , timezone , ip_cliente , autentificato , identificativo , dispositivo , sito_referente , richiesta ,  codice_risposta , qunatita_trasmissione
     * dato un determinato IP
     * @return Lista contentenente liste di stringhe che rappresentano i log per i criteri scelti
     */

    @Query(
            value = "Select giorno , mese , anno , orario , timezone , ip_cliente , autentificato , identificativo , dispositivo , sito_referente , richiesta ,  codice_risposta , qunatita_trasmissione from log_entity where ip_cliente = :ipx " ,
            nativeQuery = true
    )List<List<String>> findlogbyip(@Param("ipx") String ip  );

    /**
     *  lista di log in base giorno , mese , anno , orario , timezone , ip_cliente , autentificato , identificativo , dispositivo , sito_referente , richiesta ,  codice_risposta , qunatita_trasmissione
     * @param mese_da_cercare
     * @param giorno_cercato
     * @param anno_da_cercare
     * @param ip_da_Cercare
     * @return
     */
    @Query(
            value = "Select giorno , mese , anno , orario , timezone , ip_cliente , autentificato , identificativo , dispositivo , sito_referente , richiesta ,  codice_risposta , qunatita_trasmissione from log_entity where mese = :mesex and giorno = :giornox and anno = :annox and ip_cliente = :ipx " ,
            nativeQuery = true
    )List<List<String>> findlogMonthdayip(@Param("mesex") String mese_da_cercare , @Param("giornox") String giorno_cercato ,  @Param("annox") String anno_da_cercare , @Param("ipx") String ip_da_Cercare);

    /**
     * quarrie su
     * quantita tramissioni per un determinato ip
     *
     * @param anno_da_cercare
     * @return
     */
    @Query(
            value = "select mese , SUM(qunatita_trasmissione) as quantita_bytes_totale , count(ip_cliente) as numero_transazioni  from log_entity where anno = :annox group by   mese , anno " ,
            nativeQuery = true
    )List<List<String>> findlogMonthdayip(  @Param("annox") String anno_da_cercare );

    /**
     *  quantita tramissione per un certo ip in un certo mese
     * @param anno_da_cercare
     * @param mese_da_cercare
     * @return
     */
    @Query(
            value = "select mese , SUM(qunatita_trasmissione) as quantita_bytes_totale , count(ip_cliente) as numero_transazioni  from log_entity where anno = :annox and mese = :mesex group by   mese , anno " ,
            nativeQuery = true
    )List<List<String>> findlogcountmonth(  @Param("annox") String anno_da_cercare , @Param("mesex") String mese_da_cercare  );

    /**
     *  quarrie sul database id , giorno , data_completa , timezone , mese , orario , anno , dispositivo , autentificato , qunatita_trasmissione  , ip_cliente , identificativo , posizione_Citta , latitudine , longitudine , posizione_stato ,  sito_referente , richiesta , codice_risposta , tipo_richiesta , valutazione
     *  in base al ID
     * @param id_log
     * @return
     */
    @Query(
            value = " Select id , giorno , data_completa , timezone , mese , orario , anno , dispositivo , autentificato , qunatita_trasmissione  , ip_cliente , identificativo , posizione_Citta , latitudine , longitudine , posizione_stato ,  sito_referente , richiesta , codice_risposta , tipo_richiesta , valutazione from log_entity where id = :idx  " ,
            nativeQuery = true
    )List<List<String>> findalllogsuperid(@Param("idx") String id_log );

    /**
     * Quarrie sul database  sulla quantita di codici risposta e le loro occurence
     * @return
     */
    @Query(
            value = "select codice_risposta ,  count(*) as quantitá from log_entity group by codice_risposta" ,
            nativeQuery = true
    )List<List<String>> smartstats();
}
