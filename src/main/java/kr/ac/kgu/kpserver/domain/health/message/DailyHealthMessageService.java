package kr.ac.kgu.kpserver.domain.health.message;

import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.health.Personality;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyHealthMessageService {

    private final DailyHealthMessageRepository dailyHealthMessageRepository;

    public DailyHealthMessageService(DailyHealthMessageRepository dailyHealthMessageRepository) {
        this.dailyHealthMessageRepository = dailyHealthMessageRepository;
    }

    // FIXME - 일일 메시지 랜덤이 아닌 하루마다 고정되도록 변경 필요!!!
    public DailyHealthMessageDto getRandomMessageByUser(User user) {
        HealthcareType healthcareType = user.getHealthcareType();
        DailyHealthMessageType dailyHealthMessageType = decideDailyHealthMessageType(healthcareType);
        Personality personality = user.getPersonality();
        DailyHealthMessage dailyHealthMessage = getRandomDailyHealthMessageByType(dailyHealthMessageType, personality);
        return DailyHealthMessageDto.from(dailyHealthMessage);
    }

    private DailyHealthMessage getRandomDailyHealthMessageByType(DailyHealthMessageType type, Personality personality) {
        List<DailyHealthMessage> messages = dailyHealthMessageRepository.findByTypeAndPersonality(type, personality);
        Collections.shuffle(messages);
        return messages.stream()
                .findFirst()
                .orElseThrow(() -> new KpException(KpExceptionType.INTERNAL_SERVER_ERROR));
    }


    private DailyHealthMessageType decideDailyHealthMessageType(HealthcareType healthcareType) {
        List<DailyHealthMessageType> dailyHealthMessageTypes = Arrays.stream(DailyHealthMessageType.values())
                .filter(type -> isNotOtherHealthcareType(healthcareType, type))
                .collect(Collectors.toList());

        Collections.shuffle(dailyHealthMessageTypes);
        return dailyHealthMessageTypes.stream()
                .findFirst()
                .orElseThrow(() -> new KpException(KpExceptionType.INTERNAL_SERVER_ERROR));
    }

    private boolean isNotOtherHealthcareType(HealthcareType healthcareType, DailyHealthMessageType dailyHealthMessageType) {
        if (healthcareType == HealthcareType.HEALTH) {
            return dailyHealthMessageType != DailyHealthMessageType.STRESS;
        }
        return dailyHealthMessageType != DailyHealthMessageType.EXERCISE;
    }
}
