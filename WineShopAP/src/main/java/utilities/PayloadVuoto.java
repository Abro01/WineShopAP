package utilities;

import java.io.Serializable;
import java.io.Serial;
public class PayloadVuoto implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private final String messaggio;

    public PayloadVuoto() {
        this.messaggio = "";
    }

    public PayloadVuoto(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "PayloadVuoto{" +
                "messaggio='" + messaggio + '\'' +
                '}';
    }
}
