package kr.ac.kgu.kpserver.domain.activity;

import kr.ac.kgu.kpserver.domain.health.Personality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "activities")
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String symptom;
    @Enumerated(EnumType.STRING)
    private Personality personality;
    private String type; // TODO - enum 으로 관리

}
