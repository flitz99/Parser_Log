package LoggerPDS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;

public class DBconnection {

    //costruttore
    public String connectionString ;
    public DBconnection (String connectionAddress ){
        connectionString = connectionAddress;
        try{
            Class.forName("com.mysql.jdbc.Driver") ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    // Metodo per il singolo dato
    public void DBinsertion (String dati){
        try{
            Connection connection = null ;
            connection = DriverManager.getConnection(connectionString);
            PreparedStatement prepared = connection.prepareStatement("insert into persone (cognome, nome, eta) values (?,?,?)") ;
            prepared.setString(1,dati);
            /*

            bisogna creare il DB e sistemare la sintassi in relazione al DB

             */

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DBinsertionFile (File log_originale){
        try{
                






        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
