package kr.ac.kgu.kpserver.domain.rank.period;

import kr.ac.kgu.kpserver.util.CustomTimePeriod;

import java.time.*;

public enum RankingPeriod {
    BEFORE_DAILY, BEFORE_WEEKLY, BEFORE_MONTHLY;

    public CustomTimePeriod getTimePeriod() {
        LocalDate now = LocalDate.now();
        CustomTimePeriod.CustomTimePeriodBuilder builder = CustomTimePeriod.builder();
        if (this == BEFORE_DAILY) {
            builder
                    .from(now.minusDays(1).atStartOfDay())
                    .to(now.minusDays(1).atTime(LocalTime.MAX));
        } else if (this == BEFORE_WEEKLY) {
            builder
                    .from(now.minusWeeks(1).with(DayOfWeek.MONDAY).atTime(LocalTime.MIN))
                    .to(now.minusWeeks(1).with(DayOfWeek.FRIDAY).atTime(LocalTime.MAX));
        } else if (this == BEFORE_MONTHLY) {
            builder
                    .from(YearMonth.now().minusMonths(1).atDay(1).atStartOfDay())
                    .to(YearMonth.now().minusMonths(1).atEndOfMonth().atTime(LocalTime.MAX));
        }
        return builder.build();
    }
}
