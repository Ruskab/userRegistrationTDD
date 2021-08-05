package ikab.tdd.tdduserregistration.exceptions;

public class MissingRequiredDataException extends RuntimeException {
    public MissingRequiredDataException(String message) {
        super(message);
    }
}
