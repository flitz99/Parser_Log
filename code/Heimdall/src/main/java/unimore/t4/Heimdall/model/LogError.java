package unimore.t4.Heimdall.model;

import javax.persistence.*;

@Entity
public class LogError {

    @Id
    @SequenceGenerator(
            name = "log_err_sequence",
            sequenceName = "log_err_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "log_err_sequence"

    )
    private Long id;
    @Column(
            name = "Giorno" ,
            columnDefinition = "VARCHAR(20)"
    )

    private String DAY;
    @Column(
            name = "Mese" ,
            columnDefinition = "VARCHAR(20)"
    )
    private String MONTH;
    @Column(
            name = "Data" ,
            columnDefinition = "VARCHAR(20)"
    )
    private String MONTHDAY;
    @Column(
            name = "Orario" ,
            columnDefinition = "VARCHAR(20)"
    )
    private String TIME;
    @Column(
            name = "Anno" ,
            columnDefinition = "VARCHAR(30)"
    )
    private String YEAR;
    @Column(
            name = "Livello_Log" ,
            columnDefinition = "VARCHAR(20)"
    )
    private String LOGLEVEL;
    @Column(
            name = "pid" ,
            columnDefinition = "VARCHAR(30)"
    )
    private String PID;
    @Column(

            name = "IPV6" ,
            columnDefinition = "VARCHAR(30)"
    )
    private String ClientIP_Port;
    @Column(

            name = "IPV4" ,
            columnDefinition = "VARCHAR(20)"
    )
    private String ClientIP;
    @Column(

            name = "Tipo_di_errore" ,
            columnDefinition = "TEXT"
    )
    private String Error;
    @Column(

            name = "Path_File" ,
            columnDefinition = "TEXT"
    )
    private String Path_File;
    @Column(

            name = "Linea ",
            columnDefinition = "VARCHAR(30)"
    )
    private String Line;
    @Column(

            name = "ID_numerico ",
            columnDefinition = "VARCHAR(30)"
    )
    private String ID;
    @Column(

            name = "Messaggio" ,
            columnDefinition = "TEXT"
    )
    private String Message;
    @Column(

            name = "Dati ",
            columnDefinition = "Text"
    )
    private String Data;
    @Column(

            name = "Severit??",
            columnDefinition = "Text"
    )
    private String Severity;
    @Column(

            name = "Versione",
            columnDefinition = "Text"
    )
    private String Ver;
    @Column(

            name = "Tag1",
            columnDefinition = "Text"
    )
    private String Tag1;
    @Column(

            name = "Tag2",
            columnDefinition = "Text"
    )
    private String Tag2;
    @Column(

            name = "Tag3",
            columnDefinition = "Text"
    )
    private String Tag3;
    @Column(

            name = "Tag4",
            columnDefinition = "Text"
    )
    private String Tag4;
    @Column(

            name = "Tag5",
            columnDefinition = "Text"
    )
    private  String Tag5;
    @Column(

            name = "HostName",
            columnDefinition = "Text"
    )
    private String Hostname;
    @Column(

            name = "Url",
            columnDefinition = "Text"
    )
    private String Url;
    @Column(

            name = "Unique_ID",
            columnDefinition = "Text"
    )
    private String unique_ID;

    @Column(

            name = "Referer",
            columnDefinition = "Text"
    )
    private String Referer;
    @Column(
            name = "Data_formattata",
            columnDefinition = "DATE"
    )
    private String Data_completa = null;  // anno-mese-giorno
    public LogError() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDAY() {
        return DAY;
    }

    public void setDAY(String DAY) {
        this.DAY = DAY;
    }

    public String getMONTH() {
        return MONTH;
    }

    public void setMONTH(String MONTH) {
        this.MONTH = MONTH;
    }

    public String getMONTHDAY() {
        return MONTHDAY;
    }

    public void setMONTHDAY(String MONTHDAY) {
        this.MONTHDAY = MONTHDAY;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getLOGLEVEL() {
        return LOGLEVEL;
    }

    public void setLOGLEVEL(String LOGLEVEL) {
        this.LOGLEVEL = LOGLEVEL;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getClientIP_Port() {
        return ClientIP_Port;
    }

    public void setClientIP_Port(String clientIP_Port) {
        ClientIP_Port = clientIP_Port;
    }

    public String getClientIP() {
        return ClientIP;
    }

    public void setClientIP(String clientIP) {
        ClientIP = clientIP;
    }

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }

    public String getPath_File() {
        return Path_File;
    }

    public void setPath_File(String path_File) {
        Path_File = path_File;
    }

    public String getLine() {
        return Line;
    }

    public void setLine(String line) {
        Line = line;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getVer() {
        return Ver;
    }

    public void setVer(String ver) {
        Ver = ver;
    }

    public String getTag1() {
        return Tag1;
    }

    public void setTag1(String tag1) {
        Tag1 = tag1;
    }

    public String getTag2() {
        return Tag2;
    }

    public void setTag2(String tag2) {
        Tag2 = tag2;
    }

    public String getTag3() {
        return Tag3;
    }

    public void setTag3(String tag3) {
        Tag3 = tag3;
    }

    public String getTag4() {
        return Tag4;
    }

    public void setTag4(String tag4) {
        Tag4 = tag4;
    }

    public String getTag5() {
        return Tag5;
    }

    public void setTag5(String tag5) {
        Tag5 = tag5;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUnique_ID() {
        return unique_ID;
    }

    public void setUnique_ID(String unique_ID) {
        this.unique_ID = unique_ID;
    }

    public String getReferer() {
        return Referer;
    }

    public void setReferer(String referer) {
        Referer = referer;
    }

    public String getData_completa() {
        return Data_completa;
    }

    public void setData_completa(String data_completa) {
        Data_completa = data_completa;
    }

    @Override
    public String toString() {
        return "LogError{" +
                "id=" + id +
                ", DAY='" + DAY + '\'' +
                ", MONTH='" + MONTH + '\'' +
                ", MONTHDAY='" + MONTHDAY + '\'' +
                ", TIME='" + TIME + '\'' +
                ", YEAR='" + YEAR + '\'' +
                ", LOGLEVEL='" + LOGLEVEL + '\'' +
                ", PID='" + PID + '\'' +
                ", ClientIP_Port='" + ClientIP_Port + '\'' +
                ", ClientIP='" + ClientIP + '\'' +
                ", Error='" + Error + '\'' +
                ", Path_File='" + Path_File + '\'' +
                ", Line='" + Line + '\'' +
                ", ID='" + ID + '\'' +
                ", Message='" + Message + '\'' +
                ", Data='" + Data + '\'' +
                ", Severity='" + Severity + '\'' +
                ", Ver='" + Ver + '\'' +
                ", Tag1='" + Tag1 + '\'' +
                ", Tag2='" + Tag2 + '\'' +
                ", Tag3='" + Tag3 + '\'' +
                ", Tag4='" + Tag4 + '\'' +
                ", Tag5='" + Tag5 + '\'' +
                ", Hostname='" + Hostname + '\'' +
                ", Url='" + Url + '\'' +
                ", unique_ID='" + unique_ID + '\'' +
                ", Referer='" + Referer + '\'' +
                ", Data_completa='" + Data_completa + '\'' +
                '}';
    }
}
