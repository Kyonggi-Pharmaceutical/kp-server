package kr.ac.kgu.kpserver.domain.rank.dto;

import kr.ac.kgu.kpserver.domain.rank.all.AllRanking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllRankingResponse {

    private String nickname;
    private Integer rank;
    private Double progressRate;

    public static List<AllRankingResponse> from(List<AllRanking> allRankingList) {
        return allRankingList.stream()
                .map(ranking -> new AllRankingResponse(ranking.getNickname(), ranking.getRankScore(), ranking.getProgressRate()))
                .collect(Collectors.toList());
    }
}
