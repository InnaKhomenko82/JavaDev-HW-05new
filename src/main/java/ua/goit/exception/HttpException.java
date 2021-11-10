package ua.goit.exception;

import lombok.Getter;

public class HttpException extends RuntimeException {

    private static final long serialVersionUID = 501994088851172046L;

    @Getter
    private final int httpCode;

    public HttpException(int httpCode) {
        this.httpCode = httpCode;
    }

    public HttpException(int httpCode, String message) {
        super(message);
        this.httpCode = httpCode;
    }

    public HttpException(int httpCode, String message, Throwable cause) {
        super(message, cause);
        this.httpCode = httpCode;
    }
    
}
