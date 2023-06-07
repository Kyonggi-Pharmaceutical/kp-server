package kr.ac.kgu.kpserver.domain.user.dto;

import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String nickname;
    private Gender gender;
    private LocalDate dateOfBirth;
    private Double height;
    private Double weight;
    private MBTI mbti;
    private HealthcareType healthcareType;
    private Integer stressPoint;
    private Boolean isSmoking;
    private Boolean isAlcohol;

}
