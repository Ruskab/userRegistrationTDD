package ikab.tdd.tdduserregistration;

public class AlreadyExistentUserException extends RuntimeException {
    public AlreadyExistentUserException(String message) {
        super(message);
    }
}
