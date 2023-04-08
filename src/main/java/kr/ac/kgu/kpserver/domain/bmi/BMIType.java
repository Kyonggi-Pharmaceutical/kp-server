package kr.ac.kgu.kpserver.domain.bmi;

import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;

import java.util.Arrays;

public enum BMIType {
    UNDERWEIGHT("저체중", 0.0, 18.5),
    HEALTHY("정상", 18.5, 23.0),
    OVERWEIGHT("과체중", 23.0, 25.0),
    MILDLY_OBESE("경도비만", 25.0, 30.0),
    SEVERELY_OBESE("고도비만", 30.0, Double.MAX_VALUE);

    private final String description;
    private final Double minimumValue;
    private final Double maximumValue;

    public String getDescription() {
        return description;
    }

    BMIType(String description, Double minimumValue, Double maximumValue) {
        this.description = description;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    public static BMIType from(Double value) {
        return Arrays.stream(values())
                .filter((type) -> type.minimumValue <= value && value < type.maximumValue)
                .findFirst()
                .orElseThrow(() -> new KpException(KpExceptionType.ILLEGAL_ARGUMENT));
    }
}
