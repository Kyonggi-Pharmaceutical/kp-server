package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.health.Personality;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "exercises")
@AllArgsConstructor
@NoArgsConstructor
public class Exercise extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private ExerciseType type;
    @Enumerated(EnumType.STRING)
    private Personality personality;
    private Double met;

    private double calorie; // 칼로리를 위한 필드 추가
    private int duration = 60;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void updateCalories(User user) {
        double metToCalories = met * user.getWeight() * duration / 60; // 칼로리 계산
        this.setCalorie(metToCalories); // 칼로리 필드 업데이트
    }

    public void lowUpdateCalories(User user){
        int duration = 30;
        double lowMetToCalories = met * user.getWeight() * duration / 60; // 칼로리 계산
        this.setCalorie(lowMetToCalories); // 칼로리 필드 업데이트
    }

}
