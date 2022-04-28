package unimore.t4.Heimdall.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {
    private File dirSrcLog;
    private File[] allLogFiles;
    private LogParser logParser;

    public LogReader(String dirSrcLogName, LogParser logParser){
        dirSrcLog = new File(new File("").getAbsolutePath()+File.separator
                +dirSrcLogName);
        allLogFiles = dirSrcLog.listFiles();
        this.logParser = logParser;
        readLogFile();
    }

    public void readLogFile(){
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(allLogFiles[2]));//provo sul file gnetshop.log.2
            String sourceLogLine;
            while((sourceLogLine = br.readLine()) != null) {
                logParser.matchLogMakeMap(sourceLogLine);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
