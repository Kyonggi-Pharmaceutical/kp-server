package kr.ac.kgu.kpserver.domain.health.message;

import kr.ac.kgu.kpserver.domain.health.Personality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "daily_health_messages")
@AllArgsConstructor
@NoArgsConstructor
public class DailyHealthMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DailyHealthMessageType type;

    @Enumerated(EnumType.STRING)
    private Personality personality;

    @Size(max = 200)
    private String content;

}
