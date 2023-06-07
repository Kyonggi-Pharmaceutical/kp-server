package kr.ac.kgu.kpserver.domain.user.dto;

import kr.ac.kgu.kpserver.domain.bmi.BMI;
import kr.ac.kgu.kpserver.domain.bmi.BMIResponse;
import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.health.UserAnswer;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.Gender;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String nickname;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String profileImageUrl;
    private Gender gender;
    private LocalDate dateOfBirth;
    private Double height;
    private Double weight;
    private MBTI mbti;
    private HealthcareType healthcareType;
    private Integer stressPoint;
    private Boolean isSmoking;
    private Boolean isAlcohol;
    private BMIResponse bmi;
    private UserAnswer userAnswer;


    public static UserDto from(User user) {
        return UserDto.builder()
                .nickname(user.getNickname())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .fullName(String.format("%s %s", user.getLastName(), user.getFirstName()))
                .email(user.getEmail())
                .profileImageUrl(user.getProfileImageUrl())
                .gender(user.getGender())
                .dateOfBirth(user.getDateOfBirth())
                .height(user.getHeight())
                .weight(user.getWeight())
                .mbti(user.getMbti())
                .healthcareType(user.getHealthcareType())
                .stressPoint(user.getStressPoint())
                .isSmoking(user.getIsSmoking())
                .isAlcohol(user.getIsAlcohol())
                .bmi(BMI.calculate(user))
                .build();
    }
}
