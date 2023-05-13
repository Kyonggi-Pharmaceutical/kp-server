package kr.ac.kgu.kpserver.domain.rank.period;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class PeriodRankingService<T> {

    @Transactional
    public abstract void createDailyRanking();

    @Transactional
    public abstract void createWeeklyRanking();

    @Transactional
    public abstract void createMonthlyRanking();

    @Transactional(readOnly = true)
    public abstract List<T> getDailyRanking();

    @Transactional(readOnly = true)
    public abstract List<T> getWeeklyRanking();

    @Transactional(readOnly = true)
    public abstract List<T> getMonthlyRanking();

}
