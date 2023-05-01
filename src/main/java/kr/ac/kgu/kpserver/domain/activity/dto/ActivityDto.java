package kr.ac.kgu.kpserver.domain.activity.dto;

import kr.ac.kgu.kpserver.domain.activity.Activity;
import kr.ac.kgu.kpserver.domain.stress.Symptom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {

    private String name;
    private Symptom symptom;

    public static ActivityDto from(Activity activity) {
        return ActivityDto.builder()
                .name(activity.getName())
                .symptom(activity.getSymptom())
                .build();
    }
}
