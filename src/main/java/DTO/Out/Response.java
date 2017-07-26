package DTO.Out;

/**
 * Created by p on 2017/7/21.
 */
public class Response<Obj> {

    private Error error;
    private Obj data;

    public Response() {
        super();
    }

    public Response(Error error) {
        this.error = error;
        this.data = null;
    }

    public Response(Error error, Obj data) {
        this.error = error;
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Obj getData() {
        return data;
    }

    public void setData(Obj data) {
        this.data = data;
    }
}
