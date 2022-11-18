package site.metacoding.second.dto.resp.board;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.Board;
import site.metacoding.second.domain.User;
import site.metacoding.second.dto.resp.SessionUser;

public class BoardRespDto {

  @Setter
  @Getter
  public static class BoardSaveRespDto {
    private Integer boardId;
    private String title;
    private UserDto user;

    @Setter
    @Getter
    public static class UserDto {
      private Integer userId;
      private String username;

      public UserDto(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
      }
    }

    public BoardSaveRespDto(Board board) {
      this.boardId = board.getBoardId();
      this.title = board.getTitle();
      this.user = new UserDto(board.getUser());
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
