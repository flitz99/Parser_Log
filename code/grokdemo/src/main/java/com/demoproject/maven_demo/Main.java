package com.demoproject.maven_demo;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;

public class Main
{
    public static void main( String[] args ) {
    	/* Create a new grokCompiler instance */
    	GrokCompiler grokCompiler = GrokCompiler.newInstance();
    	grokCompiler.registerDefaultPatterns();

    	/* Grok pattern to compile, here httpd logs */
    	final Grok grok = grokCompiler.compile("%{COMBINEDAPACHELOG}");

    	/* Line of log to match */
    	//String log = "112.169.19.192 - - [06/Mar/2013:01:36:30 +0900] \"GET / HTTP/1.1\" 200 44346 \"-\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.152 Safari/537.22\"";

    	String mylog = "93.147.139.239 pippo - [08/Sep/2021:06:47:32 +0000] \"GET /search/suggest.json?q=re&resources[type]=product&resources[options][unavailable_products]=last&resources[options][fields]=title,vendor,product_type,variants.title& HTTP/1.1\" 200 10578 \"https://shop.gnet.it/products/a-b-test-email?_pos=1&_psq=a&_ss=e&_v=1.0\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Safari/605.1.15\"";
    	Match gm = grok.match(mylog);

    	/* Get the map with matches */
    	final Map<String, Object> capture = gm.capture();
		System.out.println(capture);

    	System.out.println("Client ip: "+capture.get("clientip"));
    	System.out.println("Anno: "+capture.get("YEAR"));
		File percorso= new File("");

		System.out.println(percorso.getAbsolutePath());
		File output = new File(percorso.getAbsolutePath()+File.separator+"File_output"+File.separator+"output.txt");
		BufferedWriter bf=null;

		try{
			bf= new BufferedWriter( new FileWriter(output));
			// iterate map entries

			for (Map.Entry<String, Object> entry :
					capture.entrySet()) {

				// put key and value separated by a colon
				bf.write(entry.getKey() + ":"
						+ entry.getValue());
				// new line
				bf.newLine();
			}
			bf.write("--------------------------------------------");
			bf.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {

			try {

				// always close the writer
				bf.close();
			}
			catch (Exception e) {
			}
		}

	}


}
