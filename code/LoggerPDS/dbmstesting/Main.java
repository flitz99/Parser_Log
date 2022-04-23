import parsing.Pattern;

public class Main {

    public static void main(String[] args ){

       

        Pattern prova = new Pattern
        ("CLIENT_IP:REMOTE_LOG_NAME:AUTHENTICATED_USERNAME:REQUEST_DATE:REQUEST_CODE:STATUS_CODE:BYTE_SENT:REFFERED_SITE:USER_SYSTEM");

        /*
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

    }
}