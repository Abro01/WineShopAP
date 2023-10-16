package utilities;

import java.io.Serializable;
import java.io.Serial;
public class Response implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * the response status code
     */
    private final int statusCode;
    /**
     * the response payload type
     */
    private final Class<?> payloadType;
    /**
     * the response payload
     */
    private final Object payload;

    public Response(int statusCode, Object payload) {
        this.statusCode = statusCode;
        this.payload = payload;
        this.payloadType = payload.getClass();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Class<?> getPayloadType() {
        return payloadType;
    }

    public Object getPayload() {
        return payload;
    }
}
