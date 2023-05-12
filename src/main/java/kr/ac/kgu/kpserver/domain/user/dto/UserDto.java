package kr.ac.kgu.kpserver.domain.user.dto;

import kr.ac.kgu.kpserver.domain.bmi.BMI;
import kr.ac.kgu.kpserver.domain.bmi.BMIResponse;
import kr.ac.kgu.kpserver.domain.health.UserAnswer;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.user.Gender;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDto {

    private final String nickname;
    private final String firstName;
    private final String lastName;
    private final String fullName;
    private final String email;
    private final String profileImageUrl;
    private final Gender gender;
    private final LocalDate dateOfBirth;
    private final Double height;
    private final Double weight;
    private final MBTI mbti;
    private final String exerciseGroup;
    private final Integer stressPoint;
    private final Boolean isSmoking;
    private final Boolean isAlcohol;
    private final BMIResponse bmi;
    private final UserAnswer userAnswer;


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
                .stressPoint(user.getStressPoint())
                .isSmoking(user.getIsSmoking())
                .isAlcohol(user.getIsAlcohol())
                .bmi(BMI.calculate(user))
                .build();
    }
}
