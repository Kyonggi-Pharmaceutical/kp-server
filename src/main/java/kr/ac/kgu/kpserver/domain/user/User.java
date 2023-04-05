package kr.ac.kgu.kpserver.domain.user;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.health.HealthGoal;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.overdose.Overdose;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private MBTI mbti;
    private String exerciseGroup; // TODO - 운동 그룹 enum 으로 관리
    private Integer stressPoint;
    private Boolean isSmoking;
    private Boolean isAlcohol;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "health_goal_id", referencedColumnName = "id")
    private HealthGoal healthGoal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "overdose_id", referencedColumnName = "id")
    private Overdose overdose;

    public User(String firstName, String lastName, String email, String profileImageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }

    public User update(
            Gender gender,
            LocalDate dateOfBirth,
            Double height,
            Double weight,
            MBTI mbti,
            String exerciseGroup,
            Integer stressPoint,
            Boolean isSmoking,
            Boolean isAlcohol
    ) {
        if (gender != null) this.gender = gender;
        if (dateOfBirth != null) this.dateOfBirth = dateOfBirth;
        if (height != null) this.height = height;
        if (weight != null) this.weight = weight;
        if (mbti != null) this.mbti = mbti;
        if (exerciseGroup != null) this.exerciseGroup = exerciseGroup;
        if (stressPoint != null) this.stressPoint = stressPoint;
        if (isSmoking != null) this.isSmoking = isSmoking;
        if (isAlcohol != null) this.isAlcohol = isAlcohol;
        return this;
    }
}
