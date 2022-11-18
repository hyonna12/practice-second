package site.metacoding.second.dto.req.board;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.Board;

public class BoardReqDto {

  @Setter
  @Getter
  public static class BoardSaveReqDto {
    private String title;
    private String content;

    public Board toEntity() {
      return Board.builder().title(title).content(content).build();
    }
  }

  @Setter
  @Getter
  public static class BoardUpdateReqDto {
    private Integer boardId; // 서비스 로직
    private String title;
    private String content;

    public Board toEntity() {
      return Board.builder().boardId(boardId).title(title).content(content).build();
    }
  }
}
