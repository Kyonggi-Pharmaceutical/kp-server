package kr.ac.kgu.kpserver.domain.health.message;

import lombok.Data;

@Data
public class DailyHealthMessageDto {

    private final String content;


    public static DailyHealthMessageDto from(DailyHealthMessage dailyHealthMessage) {
        return new DailyHealthMessageDto(dailyHealthMessage.getContent());
    }
}
