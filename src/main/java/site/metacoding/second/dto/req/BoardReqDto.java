package site.metacoding.second.dto.req;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.Board;

public class BoardReqDto {

  @Setter
  @Getter
  public static class BoardSaveReqDto {
    String title;
    String content;

    public Board toEntity() {
      return Board.builder().title(title).content(content).build();
    }
  }

  @Setter
  @Getter
  public static class BoardUpdateReqDto {
    String title;
    String content;

    public Board toEntity() {
      return Board.builder().title(title).content(content).build();
    }
  }
}
