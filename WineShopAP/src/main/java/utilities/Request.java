package utilities;

import java.io.Serializable;
public class Request implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * the request header
     */
    private final int header;
    /**
     * the request payload type
     */
    private final Class<?> payloadType;
    /**
     * the request payload
     */
    private final Object payload;

    public Request(int header, Object payload) {
        this.header = header;
        this.payload = payload;
        this.payloadType = payload.getClass();
    }

    public int getHeader() {
        return header;
    }

    public Class<?> getPayloadType() {
        return payloadType;
    }

    public Object getPayload() {
        return payload;
    }
}
