package site.metacoding.second.dto.resp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.Board;

public class BoardRespDto {

  @Setter
  @Getter
  public static class BoardSaveRespDto {
    Long boardId;
    String title;

    public BoardSaveRespDto(Board board) {
      this.boardId = board.getBoardId();
      this.title = board.getTitle();
    }
  }

  @Setter
  @Getter
  public static class BoardListRespDto {
    Long boardId;
    String title;

    public BoardListRespDto(Board board) {
      this.boardId = board.getBoardId();
      this.title = board.getTitle();
    }
  }
}
