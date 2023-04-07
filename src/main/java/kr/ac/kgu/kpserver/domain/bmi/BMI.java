package kr.ac.kgu.kpserver.domain.bmi;

import kr.ac.kgu.kpserver.domain.user.User;

public class BMI {
    public static BMIResponse calculate(User user) {
        Double heightByMeter = user.getHeight() / 100.0;
        Double weight = user.getWeight();

        double value = weight / (heightByMeter * heightByMeter);
        double round = Math.round(value * 10) / 10.0;
        BMIType type = BMIType.from(round);

        return new BMIResponse(round, type.getDescription());
    }
}
