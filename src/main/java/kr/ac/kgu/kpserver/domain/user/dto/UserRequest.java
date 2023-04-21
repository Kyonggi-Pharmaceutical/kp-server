package kr.ac.kgu.kpserver.domain.user.dto;

import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.Gender;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class UserRequest {

    @NotNull
    private final String nickname;
    @NotNull
    private final Gender gender;
    @NotNull
    private final LocalDate dateOfBirth;
    @NotNull
    private final Double height;
    @NotNull
    private final Double weight;
    @NotNull
    private final MBTI mbti;
    private final HealthcareType healthcareType;
    private final Integer stressPoint;
    private final Boolean isSmoking;
    private final Boolean isAlcohol;

}
