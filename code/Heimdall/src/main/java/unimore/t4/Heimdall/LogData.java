package unimore.t4.Heimdall.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LogData implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            nullable = false,
            updatable = false
    )
    private Long LogId;
    private String IpClient;
    private String Data;
    private String Time;
    private String Response;
    private String Bytes;
    private String Auth;
    private String IdentId;
    private String Timezone;
    private String UserAgent;
    private String Request;
    private String Referral;
    private String LogOriginal;

    public LogData() {
    }

    public Long getLogId() {
        return this.LogId;
    }

    public String getIpClient() {
        return this.IpClient;
    }

    public String getData() {
        return this.Data;
    }

    public String getTime() {
        return this.Time;
    }

    public String getResponse() {
        return this.Response;
    }

    public String getBytes() {
        return this.Bytes;
    }

    public String getAuth() {
        return this.Auth;
    }

    public String getIdentId() {
        return this.IdentId;
    }

    public String getTimezone() {
        return this.Timezone;
    }

    public String getUserAgent() {
        return this.UserAgent;
    }

    public String getRequest() {
        return this.Request;
    }

    public String getReferral() {
        return this.Referral;
    }

    public String getLogOriginal() {
        return this.LogOriginal;
    }
}
