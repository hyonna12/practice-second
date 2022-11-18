package site.metacoding.second.dto.resp.board;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.Board;

public class BoardRespDto {

  @Setter
  @Getter
  public static class BoardSaveRespDto {
    private Integer boardId;
    private String title;

    public BoardSaveRespDto(Board board) {
      this.boardId = board.getBoardId();
      this.title = board.getTitle();
    }
  }

  @Setter
  @Getter
  public static class BoardListRespDto {
    private Integer boardId;
    private String title;

    public BoardListRespDto(Board board) {
      this.boardId = board.getBoardId();
      this.title = board.getTitle();
    }
  }

  @Setter
  @Getter
  public static class BoardDetailRespDto {
    private Integer boardId;
    private String title;

    public BoardDetailRespDto(Board board) {
      this.boardId = board.getBoardId();
      this.title = board.getTitle();
    }
  }

  @Setter
  @Getter
  public static class BoardUpdateRespDto {
    private Integer boardId;
    private String title;
    private String content;

    public BoardUpdateRespDto(Board board) {
      this.boardId = board.getBoardId();
      this.title = board.getTitle();
      this.content = board.getContent();
    }
  }
}
