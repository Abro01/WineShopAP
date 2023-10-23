package utilities;

import java.io.Serial;
import java.io.Serializable;
public class Response implements Serializable{
    @Serial
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
        this.payloadType = payload.getClass();
        this.payload = payload;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public Object getPayload() {
        return this.payload;
    }

    public Class<?> getPayloadType() {
        return this.payloadType;
    }
}
