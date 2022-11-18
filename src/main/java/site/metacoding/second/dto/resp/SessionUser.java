package site.metacoding.second.dto.resp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.User;

@Setter
@Getter
public class SessionUser {
  private Integer userId;
  private String username;

  public User toEntity() {
    return User.builder().userId(userId).username(username).build();
  }

  public SessionUser(User user) {
    this.userId = user.getUserId();
    this.username = user.getUsername();
  }

}
