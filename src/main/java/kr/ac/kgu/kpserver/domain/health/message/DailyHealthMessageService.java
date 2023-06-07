package kr.ac.kgu.kpserver.domain.health.message;

import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.health.Personality;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public DailyHealthMessageDto getRandomMessageByUser(User user) {
        DailyHealthMessageType dailyHealthMessageType = decideRandomDailyHealthMessageTypeByUser(user);
        DailyHealthMessage dailyHealthMessage = getRandomDailyHealthMessageByTypeAndUser(dailyHealthMessageType, user);
        return DailyHealthMessageDto.from(dailyHealthMessage);
    }

    private DailyHealthMessageType decideRandomDailyHealthMessageTypeByUser(User user) {
        HealthcareType healthcareType = user.getHealthcareType();
        List<DailyHealthMessageType> dailyHealthMessageTypes = Arrays.stream(DailyHealthMessageType.values())
                .filter(type -> isNotOtherHealthcareType(healthcareType, type))
                .collect(Collectors.toList());

        int today = LocalDateTime.now().getDayOfMonth();
        int randomIndexByDay = today % (dailyHealthMessageTypes.size() + user.getId().intValue());
        return dailyHealthMessageTypes.get(randomIndexByDay);
    }

    private DailyHealthMessage getRandomDailyHealthMessageByTypeAndUser(DailyHealthMessageType type, User user) {
        Personality personality = user.getPersonality();
        List<DailyHealthMessage> messages = dailyHealthMessageRepository.findByTypeAndPersonality(type, personality);

        int today = LocalDateTime.now().getDayOfMonth();
        int randomIndexByDay = today % (messages.size() + user.getId().intValue() % messages.size());
        return messages.get(randomIndexByDay);
    }

    private boolean isNotOtherHealthcareType(HealthcareType healthcareType, DailyHealthMessageType dailyHealthMessageType) {
        if (healthcareType == HealthcareType.HEALTH) {
            return dailyHealthMessageType != DailyHealthMessageType.STRESS;
        }
        return dailyHealthMessageType != DailyHealthMessageType.EXERCISE;
    }
}
