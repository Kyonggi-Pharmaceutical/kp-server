package kr.ac.kgu.kpserver.domain.health;

public enum DailyHealthMessageType {
    EXERCISE("체중관리"),
    STRESS("스트레스관리"),
    HEALTH_GOAL("목표"),
    PROGRESS("진척도"),
    FOOD("식습관"),
    LIFE_STYLE("생활습관");

    private final String description;

    public String getDescription() {
        return description;
    }

    DailyHealthMessageType(String description) {
        this.description = description;
    }
}
