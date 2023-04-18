package kr.ac.kgu.kpserver.domain.health;

public enum Personality {
    INTROVERSION("내향성"), EXTROVERSION("외향성");

    private final String description;

    public String getDescription() {
        return description;
    }

    Personality(String description) {
        this.description = description;
    }
}
