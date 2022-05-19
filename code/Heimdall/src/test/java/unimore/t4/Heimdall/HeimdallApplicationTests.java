package unimore.t4.Heimdall;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.Match;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import unimore.t4.Heimdall.PreProcessing.JsonWriter;
import unimore.t4.Heimdall.PreProcessing.LogParser;
import unimore.t4.Heimdall.PreProcessing.LogWriter;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Classe del framework spring per occuparsi del testing
 */
@SpringBootTest
class HeimdallApplicationTests {

	private MockMvc mvc ;
	/**
	 * IN QUESTA SEZIONE SI TROVANO GLI INTEGRATION TEST DEL FRAMEWORK DI SPRING
	 */
	/**
	 * metodo del framework spring per fare i test
	 */
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
	@Test
	void shouldParseString() throws IOException {

		final Grok grok;
		Match mk ;
		Map<String, Object> capture ;
		String name = " name" ; 
		String pattern = "%{COMBINEDAPACHELOG}";
		LogParser Lp = new LogParser(null, null) ;
		String testLog = "93.147.139.239 - - [08/Sep/2021:06:49:37 +0000] \"GET /search/suggest.json?q=LI&resources[type]=product&resources[options][unavailable_products]=last&resources[options][fields]=title,vendor,product_type,variants.title& HTTP/1.1\" 200 5434 \"https://shop.gnet.it/products/report-custom-web-analytics?_pos=2&_sid=8b4303cc6&_ss=r\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Safari/605.1.15\"\n"  ;

		Lp.matchLogMakeMap(testLog, name);
		//assertEquals(Lp.getCaptureMap() , Collections.emptyMap());
		//assertThat(Lp.getCaptureMap()).equals(null);
	}




}
