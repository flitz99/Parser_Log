package unimore.t4.Heimdall.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Integer idUser ;
    @Column(nullable = false,updatable = false)
    String password;
    @Column(nullable = false,updatable = false)
    String username;

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
