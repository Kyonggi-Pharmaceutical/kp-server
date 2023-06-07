package kr.ac.kgu.kpserver.util;

public class KpException extends RuntimeException {

    public final KpExceptionType exceptionType;
    public final String message;

    public KpException(KpExceptionType exceptionType) {
        this.exceptionType = exceptionType;
        this.message = null;
    }

    public KpException(KpExceptionType exceptionType, String message) {
        this.exceptionType = exceptionType;
        this.message = message;
    }
}
