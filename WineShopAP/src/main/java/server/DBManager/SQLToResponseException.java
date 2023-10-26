package server.DBManager;

import java.io.Serial;
public class SQLToResponseException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public SQLToResponseException() {
        super();
    }

    public SQLToResponseException(String message) {
        super(message);
    }
}
