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
    private Long boardId;
    private Long userId;

    public static ArticleDto from(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setTitle(article.getTitle());
        articleDto.setDescription(article.getDescription());
        articleDto.setBoardId(article.getBoard().getId());
        articleDto.setUserId(article.getUser().getId());
        return articleDto;
    }
}
