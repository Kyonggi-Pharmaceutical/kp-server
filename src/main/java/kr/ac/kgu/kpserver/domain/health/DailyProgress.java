package kr.ac.kgu.kpserver.domain.health;

import kr.ac.kgu.kpserver.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "daily_progresses")
@AllArgsConstructor
@NoArgsConstructor
public class DailyProgress extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean check;

    // TODO - 목표 연관관계
    // TODO - 유저 연관관계

}
