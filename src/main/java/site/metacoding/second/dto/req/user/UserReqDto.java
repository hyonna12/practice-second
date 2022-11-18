package site.metacoding.second.dto.req.user;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.User;

public class UserReqDto {

  @Setter
  @Getter
  public static class UserJoinReqDto {
    private String username;
    private String password;
    private String email;

    public User toEntity() {
      return User.builder()
          .username(username).password(password).email(email)
          .build();
    }
  }

  @Setter
  @Getter
  public static class UserLoginReqDto {
    private String username;
    private String password;

    public User toEntity() {
      return User.builder()
          .username(username).password(password)
          .build();
    }
  }

}
