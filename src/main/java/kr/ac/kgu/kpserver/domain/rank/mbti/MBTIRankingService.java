package kr.ac.kgu.kpserver.domain.rank.mbti;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.rank.RankingType;
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
        List<MBTIRanking> rankingList = getMBTIRankingListByTimePeriod(RankingPeriod.BEFORE_DAILY);
        mbtiRankingRepository.saveAll(rankingList);
    }

    @Override
    public void createWeeklyRanking() {
        List<MBTIRanking> rankingList = getMBTIRankingListByTimePeriod(RankingPeriod.BEFORE_WEEKLY);
        mbtiRankingRepository.saveAll(rankingList);
    }

    @Override
    public void createMonthlyRanking() {
        List<MBTIRanking> rankingList = getMBTIRankingListByTimePeriod(RankingPeriod.BEFORE_MONTHLY);
        mbtiRankingRepository.saveAll(rankingList);
    }

    @Override
    public List<MBTIRanking> getDailyRanking() {
        RankingPeriod period = RankingPeriod.BEFORE_DAILY;
        CustomTimePeriod timePeriod = period.getTimePeriod();
        return mbtiRankingRepository.findByTargetDateAndPeriod(timePeriod.getFrom().toLocalDate(), period);
    }

    @Override
    public List<MBTIRanking> getWeeklyRanking() {
        RankingPeriod period = RankingPeriod.BEFORE_WEEKLY;
        CustomTimePeriod timePeriod = period.getTimePeriod();
        return mbtiRankingRepository.findByTargetDateAndPeriod(timePeriod.getFrom().toLocalDate(), period);
    }

    @Override
    public List<MBTIRanking> getMonthlyRanking() {
        RankingPeriod period = RankingPeriod.BEFORE_MONTHLY;
        CustomTimePeriod timePeriod = period.getTimePeriod();
        return mbtiRankingRepository.findByTargetDateAndPeriod(timePeriod.getFrom().toLocalDate(), period);
    }

    private List<MBTIRanking> getMBTIRankingListByTimePeriod(RankingPeriod rankingPeriod) {
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
                    return new MBTIRanking(
                            map.getKey(),
                            rank + 1,
                            rankingPeriod,
                            RankingType.MOST_PARTICIPATE,
                            timePeriod.getFrom().toLocalDate(),
                            map.getValue()
                    );
                }).collect(Collectors.toList());
    }
}
