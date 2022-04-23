import parsing.*;

public class Main {

    public static void main(String[] args ){

       

        Pattern prova = new Pattern("1:2:3:4:5:6:7:8:9");
        /*prenendo come esmpio di torricielli dobbiamo creare qualcosa che distingua questi pattern ,come vedete e un parto scriverlo a mano
        quindi accento volentieri modi per scriverlo più velocemente , per ora lascio cosi


         CLIENT_IP              1
         REMOTE_LOG_NAME        2
         AUTHENTICATED_USERNAME 3
         REQUEST_DATE           4
         REQUEST_CODE           5
         STATUS_CODE            6
         BYTE_SENT              7
         REFFERED_SITE          8
         USER_SYSTEM            9

            

        */

        System.out.println(prova);

        Reader leggi = new Reader();
        leggi.leggidafile();

    }
}