package kr.ac.kgu.kpserver.domain.rank.period;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class PeriodRankingService<T> {

    @Transactional
    public abstract List<T> createDailyRanking();

    @Transactional
    public abstract List<T> createWeeklyRanking();

    @Transactional
    public abstract List<T> createMonthlyRanking();

}
