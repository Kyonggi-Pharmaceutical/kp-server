package kr.ac.kgu.kpserver.domain.activity;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import kr.ac.kgu.kpserver.domain.stress.Symptom;
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
@Table(name = "activities")
@AllArgsConstructor
@NoArgsConstructor
public class Activity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String problem;
    @Enumerated(EnumType.STRING)
    private Symptom symptom;

    @OneToMany(mappedBy = "activity")
    private List<ActivityMBTI> mbtiList = new ArrayList<>();
}
