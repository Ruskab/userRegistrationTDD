package ikab.tdd.tdduserregistration.exceptions;

public class AlreadyExistentUserException extends RuntimeException {
    public AlreadyExistentUserException(String message) {
        super(message);
    }
}
