package kr.ac.kgu.kpserver.domain.health;

import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import kr.ac.kgu.kpserver.domain.health.goal.HealthGoalRepository;
import kr.ac.kgu.kpserver.domain.health.progress.DailyProgress;
import kr.ac.kgu.kpserver.domain.health.progress.DailyProgressRepository;
import kr.ac.kgu.kpserver.domain.health.progress.dto.DailyProgressResponse;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.UserRepository;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import kr.ac.kgu.kpserver.util.KpException;
import kr.ac.kgu.kpserver.util.KpExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final DailyProgressRepository dailyProgressRepository;
    private final HealthGoalRepository healthGoalRepository;
    private final UserRepository userRepository;

    /*
     * 사용자 운동 목표 데이터베이스 저장
     */
    @Transactional
    public void saveHealthGoalWithUser(Long userId, HealthGoalDto healthGoalDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));

        HealthGoal healthGoal =
                new HealthGoal(LocalDateTime.now(),
                        healthGoalDto.getWeightGoal(),
                        HealthcareType.HEALTH);

        healthGoalRepository.save(healthGoal);
        user.setHealthGoal(healthGoal);
        user.setHealthcareType(HealthcareType.HEALTH);
        userRepository.save(user);
    }

    /*
     * 일일 솔루션 달성 체크 저장
     */
    @Transactional
    public void saveDailyProgress(Long userId,
                                   DailyProgressResponse dailyProgressResponse) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));
        HealthGoal healthGoal = user.getHealthGoal();

        if (healthGoal.hasDailyProgress()) {
            throw new KpException(KpExceptionType.ALREADY_SET_DAILY_PROGRESS);
        }
        DailyProgress dailyProgress =
                new DailyProgress(dailyProgressResponse.getIsCheck(),
                        healthGoal,
                        null,
                        user);
        healthGoal.addDailyProgress(dailyProgress);
        dailyProgressRepository.save(dailyProgress);
        healthGoalRepository.save(healthGoal);
    }
    /*
     * 일일 솔루션 달성 체크 출력
     */
    @Transactional(readOnly = true)
    public boolean displayDailyProgress(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id : " + userId));
        LocalDate currentDate = LocalDate.now();
        Optional<DailyProgress> dailyProgress = dailyProgressRepository.findByUserAndCreatedAtBetween(
                user, currentDate.atStartOfDay(), currentDate.atTime(LocalTime.MAX)
        );
        return dailyProgress.map(DailyProgress::getIsCheck).orElse(false);
    }

    /*
     * 달성률 출력 코드
     * */
    @Transactional(readOnly = true)
    public HealthGoalDto getAccomplishRate(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));

        HealthGoal healthGoal = user.getHealthGoal();
        return HealthGoalDto.from(healthGoal);
    }

    /*
     * 이전 달성 여부 체크
     */
    @Transactional
    public List<DailyProgressResponse> checkedMyProgress(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));
        HealthGoal healthGoal = healthGoalRepository.findById(user.getHealthGoal().getId())
                .orElseThrow(() -> new NotFoundException("Could not find article with id: " + user.getHealthGoal().getId()));

        LocalDateTime startAt = healthGoal.getStartAt();
        LocalDateTime currentDate = LocalDateTime.now();

        List<DailyProgress> dailyProgress = dailyProgressRepository.findByUserAndHealthGoalAndCreatedAtBetween(
                user, healthGoal, startAt, currentDate);

        return dailyProgress.stream()
                .map(DailyProgressResponse::of)
                .collect(Collectors.toList());
    }

    /*
     * 솔루션 만족 선택시 몸무게 계산
     */
    public Double satisfySurveySolution(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));

        double userWeight = user.getWeight();
        double userWeightGoal = user.getHealthGoal().getWeightGoal();

        double userWeightResult = userWeight - userWeightGoal;
        if (userWeightResult <= 0) {
            return null;
        }
        return userWeightGoal;
    }
    /*
     * 사용자 불만족시 응답 받기
     * */
    @Transactional
    public void findByUserAnswer(long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Could not find user with id: " + userId));
        user.setUserAnswer(userDto.getUserAnswer());
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public HealthGoalDto getHealthGoal(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new KpException(KpExceptionType.NOT_FOUND_USER));
        HealthGoal healthGoal = user.getHealthGoal();
        UserAnswer userAnswer = user.getUserAnswer();
        if (healthGoal == null || userAnswer == null) {
            return null;
        }
        return HealthGoalDto.of(healthGoal, userAnswer);
    }
}
