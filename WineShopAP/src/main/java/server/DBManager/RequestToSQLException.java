package server.DBManager;

import java.io.Serial;
public class RequestToSQLException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public RequestToSQLException() {
        super();
    }

    public RequestToSQLException(String message) {
        super(message);
    }
}
