package kr.ac.kgu.kpserver.domain.rank;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.rank.dto.MBTICheckedCountDto;
import kr.ac.kgu.kpserver.domain.rank.period.PeriodRankingService;
import kr.ac.kgu.kpserver.domain.rank.period.RankingPeriod;
import kr.ac.kgu.kpserver.util.CustomTimePeriod;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MBTIRankingService extends PeriodRankingService<MBTIRanking> {

    private final MBTIRankingRepository mbtiRankingRepository;

    public MBTIRankingService(MBTIRankingRepository mbtiRankingRepository) {
        this.mbtiRankingRepository = mbtiRankingRepository;
    }


    @Override
    public void createDailyRanking() {
        List<MBTIRanking> rankings = getMBTIRankingsByTimePeriod(RankingPeriod.BEFORE_DAILY);
        mbtiRankingRepository.saveAll(rankings);
    }

    @Override
    public void createWeeklyRanking() {
        List<MBTIRanking> rankings = getMBTIRankingsByTimePeriod(RankingPeriod.BEFORE_WEEKLY);
        mbtiRankingRepository.saveAll(rankings);
    }

    @Override
    public void createMonthlyRanking() {
        List<MBTIRanking> rankings = getMBTIRankingsByTimePeriod(RankingPeriod.BEFORE_MONTHLY);
        mbtiRankingRepository.saveAll(rankings);
    }

    @Override
    public List<MBTIRanking> getDailyRanking() {
        CustomTimePeriod timePeriod = RankingPeriod.BEFORE_DAILY.getTimePeriod();
        return mbtiRankingRepository.findByTargetDate(timePeriod.getFrom().toLocalDate());
    }

    @Override
    public List<MBTIRanking> getWeeklyRanking() {
        CustomTimePeriod timePeriod = RankingPeriod.BEFORE_WEEKLY.getTimePeriod();
        return mbtiRankingRepository.findByTargetDate(timePeriod.getFrom().toLocalDate());
    }

    @Override
    public List<MBTIRanking> getMonthlyRanking() {
        CustomTimePeriod timePeriod = RankingPeriod.BEFORE_MONTHLY.getTimePeriod();
        return mbtiRankingRepository.findByTargetDate(timePeriod.getFrom().toLocalDate());
    }

    private List<MBTIRanking> getMBTIRankingsByTimePeriod(RankingPeriod rankingPeriod) {
        CustomTimePeriod timePeriod = rankingPeriod.getTimePeriod();

        List<Map.Entry<MBTI, Double>> sortedCheckedRateByMBTI = mbtiRankingRepository
                .findMBTIDailyProgressCheckedCountBetween(timePeriod.getFrom(), timePeriod.getTo())
                .stream()
                .collect(Collectors.toMap(MBTICheckedCountDto::getMbti, MBTICheckedCountDto::getProgressRate))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toList());

        return IntStream.range(0, sortedCheckedRateByMBTI.size())
                .mapToObj(rank -> {
                    Map.Entry<MBTI, Double> map = sortedCheckedRateByMBTI.get(rank);
                    return new MBTIRanking(map.getKey(), rank + 1, rankingPeriod, RankingType.MOST_PARTICIPATE, timePeriod.getFrom().toLocalDate());
                }).collect(Collectors.toList());
    }
}
