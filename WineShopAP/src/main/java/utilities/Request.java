package utilities;

import java.io.Serializable;

//crea la richiesta per il server
public class Request<E> implements Serializable{
    private static final long UIDSerialVersion = 6529685098267736690L;

    //richiesta
    private final Operation richiesta;

    private final E param;


    public Request(Operation o, E param) {
        this.param = param;
        this.richiesta = o;
    }

    public Request(Operation o) {
        this.richiesta = o;
        param = null;
    }

    public Operation getRichiesta() { return richiesta; }

    public E getParam() {
        return this.param;
    }
}
