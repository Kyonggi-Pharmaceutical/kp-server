package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private MBTI mbti;
    private Double met;
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserExercise> userExercises = new ArrayList<>();
    @Override
    public String toString() {
        return "Exercise{" +
                "id=" +
                ", name='" + name + '\'' +
                ", mbti=" + mbti.toString() +
                ", type=" + type.toString() +
                '}';
    }
}
