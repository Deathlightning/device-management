package xyz.kingsword.gateway.exception;

/**
 * @author: wzh date: 2019-04-14 21:24
 * @version: 1.0
 **/
public class MaxWrongTimeException extends RuntimeException {
    public MaxWrongTimeException(String message) {
        super(message);
    }

    public MaxWrongTimeException() {
        super();
    }
}
