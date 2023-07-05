package co.com.practice.exceptions;

public class AssertionsServices extends AssertionError {

    private static final long serialVersionUID= 1L;
    public static final String THE_STATUS_CODE_SERVECE_IS_NOT_EXPECTED = "The status code service response is not expected";
    public static final String QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED = "The quantity services is not expected";
    public static final String SCHEMA_SERVICE_IS_NOT_EXPECTED = "schema services response is not expected";
    public static final String THE_FIELDS_SERVICE_IS_NOT_EXPECTED = "the fields services response is not expected";
    public static final String THE_FIELDS_AND_VALUES_SERVICE_IS_NOT_EXPECTED = "the fields and values services response is not expected";

    public AssertionsServices(String message, Throwable cause) {
        super(message, cause);
    }
    public AssertionsServices(String message) {
        super(message);
    }
}
