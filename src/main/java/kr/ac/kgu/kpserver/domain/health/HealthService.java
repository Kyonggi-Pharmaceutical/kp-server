package kr.ac.kgu.kpserver.domain.health;

import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import kr.ac.kgu.kpserver.domain.health.goal.HealthGoalRepository;
import kr.ac.kgu.kpserver.domain.user.User;
import kr.ac.kgu.kpserver.domain.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final DailyProgressRepository dailyProgressRepository;
    private final HealthGoalRepository healthGoalRepository;

    /*
     * 사용자 운동 목표 데이터베이스 저장
     */
    public void saveUserWeightGoal(HealthGoalDto healthGoalDto) {
        HealthGoal healthGoal = new HealthGoal(LocalDateTime.now(), healthGoalDto.getWeightGoal());
        healthGoalRepository.save(healthGoal);
    }

    /*
     * 일일 솔루션 달성 체크 확인
     */
    public void saveDailyProgress(User user,
                                  Boolean isCheck) {
        DailyProgress dailyProgress = new DailyProgress(user,
                isCheck, LocalDate.now());
        dailyProgressRepository.save(dailyProgress);
    }

    /*
     * 매달 솔루션 달성률 계산
     */
    public Double calculationHealthGoal(HealthGoal healthGoal) {

        List<DailyProgress> dailyProgresses = healthGoal.getDailyProgresses();
        //백분율 계산
        long trueCount = dailyProgresses.stream().filter(DailyProgress::isCheck).count();
        double accomplishRate = Math.round(((double) trueCount / 30) * 1000.0) / 10.0;
        healthGoal.setAccomplishRate(accomplishRate);
        healthGoalRepository.save(healthGoal);
        return accomplishRate;
    }

    /*
     * 이전 달성 여부 체크
     */
    public List<String> checkedMyProgress(List<DailyProgress> dailyProgresses) {
        return dailyProgresses.stream()
                .filter(dp -> dp.getDate().isBefore(LocalDate.now()))
                .map(dp -> dp.isCheck() ? "완료" : "미완료")
                .collect(Collectors.toList());
    }

    /*
     * 솔수션 종료값 저장
     */
    public void saveEndSolutionDate(HealthGoal healthGoal) {
        LocalDateTime finishDate = LocalDateTime.now();
        healthGoal.setEndAt(finishDate);
        healthGoalRepository.save(healthGoal);
    }

    /*
     * 솔루션 만족도 만족 선택시 몸무게 계산
     */
    public Double satisfySurveySolution(User user,
                                        UserDto userDto,
                                        HealthGoal healthGoal) {
        double userWeight = userDto.getWeight();
        user.setWeight(userWeight);

        double userWeightGoal = healthGoal.getWeightGoal();

        double userWeightResult = userWeight - userWeightGoal;
        if (userWeightResult <= 0) {
            return null;
        }
        return userWeightGoal;
    }
}
