package kr.ac.kgu.kpserver.domain.exercise;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserExerciseDto {
    private Long id;
    private Long userId;
    private Long exerciseId;
    private double cal;
    private int time;

    public static UserExerciseDto of(UserExercise userExercise) {
        return UserExerciseDto.builder()
                .id(userExercise.getId())
                .userId(userExercise.getUser().getId())
                .exerciseId(userExercise.getExercise().getId())
                .cal(userExercise.getCal())
                .time(userExercise.getTime())
                .build();
    }
}
