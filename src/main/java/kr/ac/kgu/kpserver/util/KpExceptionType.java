package kr.ac.kgu.kpserver.util;

import org.springframework.http.HttpStatus;

public enum KpExceptionType {

    NOT_FOUND_USER(HttpStatus.NOT_FOUND, 101, "해당 유저를 찾을 수 없습니다."),
    ALREADY_SIGN_UP(HttpStatus.BAD_REQUEST, 102, "이미 회원가입한 유저 입니다."),
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, 103, "인증에 실패했습니다."),
    ILLEGAL_ARGUMENT(HttpStatus.BAD_REQUEST, 104, "부적절한 값입니다."),
    NOT_SIGN_UP(HttpStatus.BAD_REQUEST, 105, "회원가입하지 않은 유저입니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "부적절한 값입니다."),


    TEST(HttpStatus.BAD_REQUEST, 999, "ERROR MESSAGE");

    public final HttpStatus httpStatus;
    public final int errorCode;
    public final String errorMessage;

    KpExceptionType(HttpStatus httpStatus, int errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
