package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_exercises")
@AllArgsConstructor
@NoArgsConstructor
public class UserExercise extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double cal;

    public UserExercise(User user, Exercise exercise, double calories) {
        this.user = user;
        this.exercise = exercise;
        this.cal = calories;
    }

}
