package kr.ac.kgu.kpserver.domain.rank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCheckedCountDto {

    private Long userId;
    private String nickname;
    private Long totalCount;
    private Long checkedCount;

    public Double getProgressRate() {
        return Math.round(((double) checkedCount / totalCount) * 1000.0) / 10.0;
    }
}
