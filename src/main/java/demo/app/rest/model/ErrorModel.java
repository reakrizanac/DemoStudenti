package demo.app.rest.model;

public class ErrorModel extends StudentModel{
    public static final ErrorModel ERR_001 = new ErrorModel(1,"Status 400");
    public static final ErrorModel ERR_MIN_LENGTH = new ErrorModel(1,"Minimum name length is not acquired");
    public static final ErrorModel ERR_OIB_LENGTH = new ErrorModel(1,"OIB length is not wrong.");

    int code;
    String message;

    public ErrorModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
