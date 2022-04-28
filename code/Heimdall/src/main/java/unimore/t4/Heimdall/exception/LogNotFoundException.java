package unimore.t4.Heimdall.exception;

public class LogNotFoundException extends RuntimeException{
    public LogNotFoundException(String messaggio) {
        super(messaggio);
    }
}
