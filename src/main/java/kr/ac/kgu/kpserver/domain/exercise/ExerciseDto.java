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

    public Exercise mapToEntity(ExerciseDto exerciseDto) {

        Exercise exercise = new Exercise();
        exercise.setId(exerciseDto.getId());
        exercise.setName(exerciseDto.getName());
        exercise.setType(exerciseDto.getExerciseGroup());
        exercise.setPersonality(exerciseDto.getPersonality());
        exercise.setCalorie(exerciseDto.getCalorie());
        exercise.setDuration(exerciseDto.getDuration());

        return exercise;
    }
}
