package az.cybernet.managingtraveltours.exception;

import static az.cybernet.managingtraveltours.model.constants.LocalizationConstants.ERROR_BUNDLE;
import static az.cybernet.managingtraveltours.util.LocalizationUtil.LOCALIZATION_UTIL;

public abstract class BaseApiException extends RuntimeException {

    protected BaseApiException(ErrorMessage message, Object... arguments) {
        super(LOCALIZATION_UTIL.getMessageByKey(ERROR_BUNDLE, message.getCode()).formatted(arguments));
    }
}