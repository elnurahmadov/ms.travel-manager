package az.cybernet.managingtraveltours.exception;

public class NotFoundException extends BaseApiException {

    public NotFoundException(ErrorMessage message, Object... arguments) {
        super(message, arguments);
    }
}