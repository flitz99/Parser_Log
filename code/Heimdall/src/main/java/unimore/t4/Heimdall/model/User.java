package unimore.t4.Heimdall.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Classe che identifica l'utente che sta usando l'applicativo web
 * /
public class User {
    /**
     *chiave principale dell'utente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Integer idUser ;
    /**
     *password dell'utente
     */
    @Column(nullable = false,updatable = false)
    String password;
    /**
     *username dell'utente
     */
    @Column(nullable = false,updatable = false)
    String username;
    /**
     *setter dell'idUser  autogenerato e assegnato all'utente, preso dal db
     *@param idUser id Utente autogenerato e assegnato all'utente, preso dal db
     */
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    /**
     *setter della password dell'utente
     *@param password password dell utente
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     *setter dell'username dell'utente
     *@param username username dell'utente
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
