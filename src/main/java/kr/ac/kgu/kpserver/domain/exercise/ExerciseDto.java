package kr.ac.kgu.kpserver.domain.exercise;

import lombok.*;

@Data
@Builder
public class ExerciseDto {
    // 운동 타입 저장
    private final ExerciseType exerciseGroup;

    public static ExerciseDto of(Exercise exercise) {
        return ExerciseDto.builder()
                .exerciseGroup(exercise.getType())
                .build();
    }

}