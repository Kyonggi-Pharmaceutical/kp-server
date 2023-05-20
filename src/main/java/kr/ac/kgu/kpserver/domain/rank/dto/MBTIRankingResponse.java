package kr.ac.kgu.kpserver.domain.rank.dto;

import kr.ac.kgu.kpserver.domain.mbti.MBTI;
import kr.ac.kgu.kpserver.domain.rank.MBTIRanking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MBTIRankingResponse {

    private MBTI mbti;
    private Integer rank;

    public static List<MBTIRankingResponse> from(List<MBTIRanking> mbtiRankingList) {
        return mbtiRankingList.stream()
                .map(ranking -> new MBTIRankingResponse(ranking.getMbti(), ranking.getRankScore()))
                .collect(Collectors.toList());
    }
}
