package kr.ac.kgu.kpserver.domain.exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDto {
    private Long id;
    private String name;
    private ExerciseType type;
    private Double cal;
    private int time;

    public static ExerciseDto from(Exercise exercise) {
        return new ExerciseDto(
                exercise.getId(),
                exercise.getName(),
                exercise.getType(),
                null,
                exercise.getTime()
        );

    }
}
