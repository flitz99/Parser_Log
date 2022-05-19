package unimore.t4.Heimdall.PreProcessing;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.Match;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.expression.spel.ast.NullLiteral;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogParserTest {

    Match mk ;
    Map<String, Object> capture ;
    JsonWriter jw = null;
    LogWriter LW = null;
    String pattern = "%{COMBINEDAPACHELOG}";
    String logLine = "93.147.139.239 - - [08/Sep/2021:06:49:37 +0000] \"GET /search/suggest.json?q=LI&resources[type]=product&resources[options][unavailable_products]=last&resources[options][fields]=title,vendor,product_type,variants.title& HTTP/1.1\" 200 5434 \"https://shop.gnet.it/products/report-custom-web-analytics?_pos=2&_sid=8b4303cc6&_ss=r\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Safari/605.1.15\"\n"  ;


    @Test
    void matchLogMakeMap() throws IOException {
        /**
         * Metodo per testare abilità di parsing del Parser
         */
        final Grok grok;
        Match mk ;
        Map<String, Object> capture ;
        JsonWriter jw = null;
        LogWriter LW = null;
        String pattern = "%{COMBINEDAPACHELOG}";
        LogParser Lp = new LogParser(null, null) ;
        Lp.matchLogMakeMap(logLine, null);
        /**
         * Quando viene creato un oggetto con name:null il test fallisce, bisogna quindi risolvere il roblema
         * degli inserimenti nulli nelle variabili
         */
        if (Lp.getCaptureMap().isEmpty()){
            System.out.println("mappa non nulla");
        }else {
            System.err.println("ERRORE IN PARSING");
        }

    }
    @Test
    void matchLogMakerEmpty(){
        LogParser Lpn = new LogParser(null,null);

        if (Lpn.equals(null) ){
        System.out.println("null logparser");
        }
        if (!Lpn.equals(null)){
            System.out.println("errore dovrebbe essere nullo");
        }
    }

    @Test
    void getCaptureMap() throws IOException {
        LogParser LP = new LogParser(LW, jw);
        LP.matchLogMakeMap(logLine, null);
        if (LP.getCaptureMap() != null) {
            System.out.println("Test riuscito");
        }
        else {
            System.err.println("Test sbagliato");
        }
    }
}