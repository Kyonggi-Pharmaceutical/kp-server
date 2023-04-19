package kr.ac.kgu.kpserver.domain.mbti;

import kr.ac.kgu.kpserver.domain.health.Personality;

public enum MBTI {
    ISTJ(Personality.INTROVERSION),
    ISFJ(Personality.INTROVERSION),
    INFJ(Personality.INTROVERSION),
    INTJ(Personality.INTROVERSION),
    ISTP(Personality.INTROVERSION),
    ISFP(Personality.INTROVERSION),
    INFP(Personality.INTROVERSION),
    INTP(Personality.INTROVERSION),
    ESTP(Personality.EXTROVERSION),
    ESFP(Personality.EXTROVERSION),
    ENFP(Personality.EXTROVERSION),
    ENTP(Personality.EXTROVERSION),
    ESTJ(Personality.EXTROVERSION),
    ESFJ(Personality.EXTROVERSION),
    ENFJ(Personality.EXTROVERSION),
    ENTJ(Personality.EXTROVERSION);

    private final Personality personality;

    public Personality getPersonality() {
        return personality;
    }

    MBTI(Personality personality) {
        this.personality = personality;
    }
}
