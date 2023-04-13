package kr.ac.kgu.kpserver.domain.exercise;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExerciseDto {
    private final ExerciseType exerciseGroup;

    public static ExerciseDto of(Exercise exercise) {
        return ExerciseDto.builder()
                .exerciseGroup(exercise.getType())
                .build();
    }
}
