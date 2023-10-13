package utilities;

import java.io.Serializable;
public class Response<T> implements Serializable{
    private static final long UIDSerialVersion = 6529675098267736690L;

    public enum State
    {
        OK, ERROR, ATTENZIONE
    }

    private final Operation operation;
    private final T response;
    private final State outcome;
    private final String info;

    public Response(Operation operation, T response, State outcome) {
        this.operation = operation;
        this.response = response;
        this.outcome = outcome;
        this.info = null;
    }

    public Response(Operation operation, State outcome, String info) {
        this.operation = operation;
        this.outcome = outcome;
        this.info = info;
        this.response = null;
    }

    public Response(Operation operation, T response, State outcome, String info) {
        this.operation = operation;
        this.response = response;
        this.outcome = outcome;
        this.info = info;
    }

    public Response(Operation operation, State outcome) {
        this.operation = operation;
        this.outcome = outcome;
        this.response = null;
        this.info = null;
    }

    public Operation getOperation() {
        return operation;
    }

    public T getResponse() {
        return response;
    }

    public State getOutcome() {
        return outcome;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        String s = "";

        s += "Operazione: " + getOperation();
        s += "/OutCome: " + getOutcome();
        s += "/Info: " + getInfo();

        if (getResponse() != null) {
            s += "/Response: " + getResponse().toString();
        } else {
            s += "/Response: null";
        }
        return s;
    }
}
