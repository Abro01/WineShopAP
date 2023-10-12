package utilities;

import java.io.Serial;
import java.io.Serializable;

//crea la richiesta per il server
public class Richiesta<E> implements Serializable{
    private static final long UIDSerialVersion = 6529685098267736690L;

    //richiesta
    private final Operation richiesta;

    private final E param;


    public Richiesta(Operation o, E param) {
        this.param = param;
        this.richiesta = o;
    }

    public Richiesta(Operation o) {
        this.richiesta = o;
        param = null;
    }

    public E getParam() {
        return this.param;
    }
}
