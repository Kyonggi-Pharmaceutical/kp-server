package kr.ac.kgu.kpserver.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KpErrorResponse {

    private final int errorCode;
    private final String errorMessage;
}
