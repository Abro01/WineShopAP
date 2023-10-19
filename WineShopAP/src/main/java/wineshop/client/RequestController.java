package wineshop.client;

import utilities.Costanti;
import utilities.Request;
import utilities.Response;
import utilities.PayloadVuoto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class RequestController {
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public RequestController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public <T> Response makeRequest(int header, T payload){
        Response r = null;

        try {
            out.writeObject(new Request(header, payload));
            r = (Response) in.readObject();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return r;
    }

    public void CloseConnection(){
        try {
            out.writeObject(new Request(Costanti.Logout, new PayloadVuoto()));
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
