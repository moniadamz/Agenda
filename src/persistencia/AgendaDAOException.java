package persistencia;

@SuppressWarnings("serial")
public class AgendaDAOException extends Exception {

    public AgendaDAOException() {
    }

    public AgendaDAOException(String msg) {
        super(msg);
    }

    public AgendaDAOException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
