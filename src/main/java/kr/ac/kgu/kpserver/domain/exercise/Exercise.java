package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.BaseEntity;
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
    private Double met;
    @OneToMany(mappedBy = "exercise")
    private List<ExerciseMBTI> mbtiList = new ArrayList<>();

}
