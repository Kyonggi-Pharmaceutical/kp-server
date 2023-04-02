package kr.ac.kgu.kpserver.domain.overdose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "overdoes")
@AllArgsConstructor
@NoArgsConstructor
public class Overdose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OverdoseGroup overdoseGroup;
    private Integer days;

    // TODO - 유저 연관관계 추가
}
