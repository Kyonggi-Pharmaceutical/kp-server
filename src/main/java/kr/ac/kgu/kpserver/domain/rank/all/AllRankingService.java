package kr.ac.kgu.kpserver.domain.rank.all;

import kr.ac.kgu.kpserver.domain.rank.RankingType;
import kr.ac.kgu.kpserver.domain.rank.dto.UserCheckedCountDto;
import kr.ac.kgu.kpserver.domain.rank.period.PeriodRankingService;
import kr.ac.kgu.kpserver.domain.rank.period.RankingPeriod;
import kr.ac.kgu.kpserver.util.CustomTimePeriod;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AllRankingService extends PeriodRankingService<AllRanking> {

    private final AllRankingRepository allRankingRepository;

    public AllRankingService(AllRankingRepository allRankingRepository) {
        this.allRankingRepository = allRankingRepository;
    }


    @Override
    public void createDailyRanking() {
        List<AllRanking> rankingList = getAllRankingListByTimePeriod(RankingPeriod.BEFORE_DAILY);
        allRankingRepository.saveAll(rankingList);
    }

    @Override
    public void createWeeklyRanking() {
        List<AllRanking> rankingList = getAllRankingListByTimePeriod(RankingPeriod.BEFORE_WEEKLY);
        allRankingRepository.saveAll(rankingList);
    }

    @Override
    public void createMonthlyRanking() {
        List<AllRanking> rankingList = getAllRankingListByTimePeriod(RankingPeriod.BEFORE_MONTHLY);
        allRankingRepository.saveAll(rankingList);
    }

    @Override
    public List<AllRanking> getDailyRanking() {
        CustomTimePeriod timePeriod = RankingPeriod.BEFORE_DAILY.getTimePeriod();
        return allRankingRepository.findByTargetDate(timePeriod.getFrom().toLocalDate());
    }

    @Override
    public List<AllRanking> getWeeklyRanking() {
        CustomTimePeriod timePeriod = RankingPeriod.BEFORE_WEEKLY.getTimePeriod();
        return allRankingRepository.findByTargetDate(timePeriod.getFrom().toLocalDate());
    }

    @Override
    public List<AllRanking> getMonthlyRanking() {
        CustomTimePeriod timePeriod = RankingPeriod.BEFORE_MONTHLY.getTimePeriod();
        return allRankingRepository.findByTargetDate(timePeriod.getFrom().toLocalDate());
    }

    private List<AllRanking> getAllRankingListByTimePeriod(RankingPeriod rankingPeriod) {
        CustomTimePeriod timePeriod = rankingPeriod.getTimePeriod();

        List<UserCheckedCountDto> sortedCheckedRateByUser = allRankingRepository
                .findUserDailyProgressCheckedCountBetween(timePeriod.getFrom(), timePeriod.getTo())
                .stream()
                .sorted(Comparator.comparing(UserCheckedCountDto::getProgressRate).reversed())
                .collect(Collectors.toList());

        return IntStream.range(0, sortedCheckedRateByUser.size())
                .mapToObj(rank -> {
                    UserCheckedCountDto userCheckedCountDto = sortedCheckedRateByUser.get(rank);
                    return new AllRanking(
                            userCheckedCountDto.getUserId(),
                            userCheckedCountDto.getNickname(),
                            rank + 1,
                            rankingPeriod,
                            RankingType.MOST_PARTICIPATE,
                            timePeriod.getFrom().toLocalDate(),
                            userCheckedCountDto.getProgressRate()
                    );
                }).collect(Collectors.toList());
    }
}
