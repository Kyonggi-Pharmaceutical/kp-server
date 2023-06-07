package kr.ac.kgu.kpserver.domain.health.progress.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyProgressCheckTodayResponse {

    private boolean check;

}
