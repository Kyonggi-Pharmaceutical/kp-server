package kr.ac.kgu.kpserver.domain.user;

import io.swagger.v3.oas.annotations.Hidden;
import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.activity.Activity;
import kr.ac.kgu.kpserver.domain.activity.UserActivity;
import kr.ac.kgu.kpserver.domain.board.Likes.Like;
import kr.ac.kgu.kpserver.domain.exercise.UserExercise;
import kr.ac.kgu.kpserver.domain.health.HealthcareType;
import kr.ac.kgu.kpserver.domain.health.Personality;
import kr.ac.kgu.kpserver.domain.health.UserAnswer;
import kr.ac.kgu.kpserver.domain.health.goal.HealthGoal;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.overdose.Overdose;
import kr.ac.kgu.kpserver.domain.stress.goal.StressGoal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Hidden
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String firstName;
    private String lastName;
    private String email;
    private String profileImageUrl;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    private Double height;
    private Double weight;
    @Enumerated(EnumType.STRING)
    private UserAnswer userAnswer = UserAnswer.NORMAL;
    @Enumerated(EnumType.STRING)
    private MBTI mbti;
    @Enumerated(EnumType.STRING)
    private HealthcareType healthcareType;
    private Integer stressPoint;
    private Boolean isSmoking;
    private Boolean isAlcohol;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "health_goal_id", referencedColumnName = "id")
    private HealthGoal healthGoal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stress_goal_id", referencedColumnName = "id")
    private StressGoal stressGoal;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserActivity> userActivities = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "overdose_id", referencedColumnName = "id")
    private Overdose overdose;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserExercise> userExercises = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<>();

    public User(String firstName, String lastName, String email, String profileImageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }

    public Boolean isSignUp() {
        return healthcareType != null &&
                nickname != null &&
                height != null &&
                weight != null &&
                email != null &&
                firstName != null &&
                lastName != null &&
                gender != null &&
                dateOfBirth != null &&
                mbti != null;
    }

    public Personality getPersonality() {
        return mbti.getPersonality();
    }
    public User update(
            String nickname,
            Gender gender,
            LocalDate dateOfBirth,
            Double height,
            Double weight,
            MBTI mbti,
            HealthcareType healthcareType,
            Integer stressPoint,
            Boolean isSmoking,
            Boolean isAlcohol
    ) {
        if (nickname != null) this.nickname = nickname;
        if (gender != null) this.gender = gender;
        if (dateOfBirth != null) this.dateOfBirth = dateOfBirth;
        if (height != null) this.height = height;
        if (weight != null) this.weight = weight;
        if (mbti != null) this.mbti = mbti;
        if (healthcareType != null) this.healthcareType = healthcareType;
        if (stressPoint != null) this.stressPoint = stressPoint;
        if (isSmoking != null) this.isSmoking = isSmoking;
        if (isAlcohol != null) this.isAlcohol = isAlcohol;
        return this;
    }

    public Set<UserActivity> updateUserActivities(List<Activity> newActivities) {
        this.userActivities = newActivities.stream()
                .map(activity -> new UserActivity(null, this, activity))
                .collect(Collectors.toSet());
        return userActivities;
    }
}
