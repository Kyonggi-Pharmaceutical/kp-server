package kr.ac.kgu.kpserver.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomTimePeriod {

    private LocalDateTime from;
    private LocalDateTime to;

}
