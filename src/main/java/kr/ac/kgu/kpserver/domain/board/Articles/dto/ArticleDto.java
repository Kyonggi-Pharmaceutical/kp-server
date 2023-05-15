package kr.ac.kgu.kpserver.domain.board.Articles.dto;

import kr.ac.kgu.kpserver.domain.board.Articles.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String description;
    private boolean canEdit;
    private Long userId;

    private String username;


    public static ArticleDto of(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .userId(article.getUser().getId())
                .username(article.getUsername())
                .build();
    }

}
