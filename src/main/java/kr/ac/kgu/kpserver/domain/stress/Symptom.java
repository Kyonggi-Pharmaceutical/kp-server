package kr.ac.kgu.kpserver.domain.stress;

public enum Symptom {

    LETHARGIC("무기력함"),
    DEPRESSED("우울함"),
    ANXIETY("불안함"),
    ANGER("분노");


    private final String description;

    Symptom(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
