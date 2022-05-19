/*****************************
	Test JsonWriter
******************************/

class JsonWriterTest {

	@Test
    	void writeOnJson() {
        	Map<String, Object> captureMap = new HashMap<String, Object>() ;
        	captureMap.put("test", 1) ;
        	String name = "name" ;
        	String dirDstJsonName = "File_Json" ;
        	JsonWriter jw = new JsonWriter(dirDstJsonName) ;
        	
        	jw.writeOnJson( captureMap , name );
        
        	// Crea il file nella directory richiesta
    }

}

/*************************
	Test LogParser
**************************/

class LogParserTest {

	@Test
    	void matchLogMakeMap() throws IOException {
        	String testLog = "93.147.139.239 - - [07/Sep/2021:08:21:07 +0000] \"GET / HTTP/1.1\" 200 40430 \"-\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"\n" ;
        	String name = "name";
        	LogParser lp = new LogParser( "File_output" , "File_Json" );
        	lp.matchLogMakeMap(testLog, name);
        	Path path = Paths.get( "/Users/jacopovecchi/PDS/2022t4/code/Heimdall/File_output/name");
        	if(path.toFile().isFile()) {
            		System.out.println(path + " Exists");
        	}
        	else {
            		System.out.println(path + " Do not Exists");
        	}
        }
    
}

/*************************
	Test LogWriter
**************************/

class LogWriterTest {

	Map<String, Object> map = null;
	private String dirDstLog = "src/test/java/unimore/t4/Heimdall/PreProcessing/writetest";
	
	@Test
    	void writeLogtest() {
        	LogWriter lw = new LogWriter(dirDstLog) ;
        	lw.writeLog(map,"fileTesting");
        	File directory = new File("src/test/java/unimore/t4/Heimdall/PreProcessing/writetest") ;
		File[] files = directory.listFiles();
		
		//Definiamo il path della cartella String folderPath = "C:/src/test/java/unimore/t4/Heimdall/PreProcessing";
		//Inizializziamo il file File folder = new File(folderPath);
		//Verificchiamo che questo sia esistente e che sia in una cartella

		boolean existsFolder = directory.isDirectory();
      			if (existsFolder) {
          			System.err.println("errore");
      			}
      			else {
          			System.out.println("tutto ok");
      			}
    	}

}


/*********************
	Test LogReader
**********************/

class LogRederTest {

	LogParser logP = new LogParser(null,null);
	
	@Test
    	void logReader() {
      		LogReader LR = new LogReader(null, null);
      		
        	if (LR.equals(null)) {
            		System.out.println("Test riuscito");
        	}
        	else {
            		System.err.println("Test non riuscito");
        	}
    	}
    	
    	@Test
    	void readAllLogFile() {
        	LogReader lR = new LogReader("/Users/jacopovecchi/PDS/2022t4/code/Heimdall/src/test/java/unimore/t4/Heimdall/todelete",logp);
        	
        	lR.readAllLogFile();
        	if (lR.equals(null)) {
            		System.out.println("creato oggeto nullo ");
        	}
        	
        	//Il metodo readAllLogFile deve implemetare un controllo
        	//per le variabili null
        }

}

/*******************************
	Test LogProcessing
********************************/

class LogProcessingTest {

	@Test
	void logProcessing() {
		LogProcessing LP = new LogProcessing("c","a","b");
        	String dirD = "/Users/jacopovecchi/PDS/2022t4/code/Heimdall/src/test/java/unimore/t4/Heimdall/todelete";
        	File pathdaEliminare = new File("src/test/java/unimore/t4/Heimdall/todelete");
        		
        		try {
          			if (LP.deleteDirectory(pathdaEliminare)){
              				System.out.println("direcotry cancellata");
          			}
          			else {
              				System.out.println("directory sbagliata");
          			}
        		}
        		catch (Exception e) {
            			throw new RuntimeException(e);
        		}
	}
	
	 @Test
	 
    	//Test che testa il log processing con una non directory
    	
    	void logProcessing_empty() {
  
        	LogProcessing LP = new LogProcessing("c","a","b");
        	
        	//La stringa dirD non contiene più il percorso della directory ma una parola.
   
        	String dirD = "stringa";
        	File pathdaEliminare = new File("src/test/java/unimore/t4/Heimdall/todelete");
        	try {
            		LP.deleteDirectory(pathdaEliminare);
        	} catch (Exception e) {
            		throw new RuntimeException(e);
        	}
        	/**
         	* Dopo che abbiamo fatto partire il test ci siamo ritrovati il codice
         	* completamente cancellato.
         	* Ribandiamo ancora una volta: ESEGUIRE QUESTO TEST SU UNA COPIA DEL CODICE
         	* E NON SU QUELLO ORIGINALE
         	*/
         	
         	//AGGIORNAMENTO: il codice è stato corretto e il test funziona
    	}

}

/**************************
	Test LogParser
***************************/

public LogParserTest {

	Match mk ;
    	Map<String, Object> capture ;
    	JsonWriter jw = null;
    	LogWriter LW = null;
    	String pattern = "%{COMBINEDAPACHELOG}";
    	String logLine = "93.147.139.239 - - [08/Sep/2021:06:49:37 +0000] \"GET /search/suggest.json?q=LI&resources[type]=product&resources[options][unavailable_products]=last&resources[options][fields]=title,vendor,product_type,variants.title& HTTP/1.1\" 200 5434 \"https://shop.gnet.it/products/report-custom-web-analytics?_pos=2&_sid=8b4303cc6&_ss=r\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Safari/605.1.15\"\n";
    	
    	@Test
    	void matchLogMakeMap() throws IOException {
        
        	//Metodo per testare abilità di parsing del Parser
         
        	final Grok grok;
        	Match mk ;
        	Map<String, Object> capture ;
        	JsonWriter jw = null;
        	LogWriter LW = null;
        	String pattern = "%{COMBINEDAPACHELOG}";
        	LogParser Lp = new LogParser(null, null) ;
        	Lp.matchLogMakeMap(logLine, null);

         	//Quando viene creato un oggetto con name:null il test fallisce, bisogna quindi risolvere il roblema
         	//degli inserimenti nulli nelle variabili
         
        	if (Lp.getCaptureMap().isEmpty()){
            		System.out.println("mappa non nulla");
        	}
        	else {
            		System.err.println("ERRORE IN PARSING");
        	}

    	}
    	
    	@Test
    	void matchLogMakerEmpty() {
        	LogParser Lpn = new LogParser(null,null);

        	if (Lpn.equals(null) ){
        		System.out.println("null logparser");
        	}
        	else if (!Lpn.equals(null)) {
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

/**********************************
	Test HeimdallApplication
***********************************/

class HeimdallApplicationTests {

	@Test
	void contextLoads() {
		LogParser Lpn = new LogParser(null,null);

		if (Lpn.equals(null) ){
			System.out.println("null logparser");
		}
		if (!Lpn.equals(null)){
			System.out.println("errore dovrebbe essere nullo");
		}

	}

}
