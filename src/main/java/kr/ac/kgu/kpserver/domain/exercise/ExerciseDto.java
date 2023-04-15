package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.health.Personality;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExerciseDto {
    private final Long id;
    private final String name;
    private final ExerciseType exerciseGroup;
    private final Personality personality;
    private final double calorie;
    private final int duration;

    public ExerciseDto mapToDto(Exercise exercise) {
        return ExerciseDto.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .exerciseGroup(exercise.getType())
                .personality(exercise.getPersonality())
                .calorie(exercise.getCalorie())
                .duration(exercise.getDuration())
                .build();
    }
}
