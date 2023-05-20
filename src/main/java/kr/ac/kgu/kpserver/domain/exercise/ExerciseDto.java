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
    private double cal;
    private int time;

    public static ExerciseDto from(Exercise exercise, double cal, int time) {
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setId(exercise.getId());
        exerciseDto.setName(exercise.getName());
        exerciseDto.setType(exercise.getType());
        exerciseDto.setCal(cal);
        exerciseDto.setTime(time);
        return exerciseDto;
    }
}
