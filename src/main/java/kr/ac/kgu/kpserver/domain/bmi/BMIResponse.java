package kr.ac.kgu.kpserver.domain.bmi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BMIResponse {

    private final Double value;
    private final String description;

}
