package kr.ac.kgu.kpserver.domain.exercise;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "exercise_mbti")
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseMBTI extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MBTI mbti;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

}