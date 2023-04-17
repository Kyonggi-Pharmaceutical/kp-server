package kr.ac.kgu.kpserver.domain.board.dto;

import kr.ac.kgu.kpserver.domain.board.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long boardId;
    private Long userId;

    public static ArticleDto from(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setTitle(article.getTitle());
        articleDto.setDescription(article.getDescription());
        articleDto.setCreatedAt(article.getCreateAt());
        articleDto.setUpdatedAt(article.getUpdateAt());
        articleDto.setBoardId(article.getBoard().getId());
        articleDto.setUserId(article.getUser().getId());
        return articleDto;
    }
}
