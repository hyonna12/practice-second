package site.metacoding.second.dto.resp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.User;

@Setter
@Getter
public class SessionUser {
  Integer userId;
  String username;

  public SessionUser(User user) {
    this.userId = user.getUserId();
    this.username = user.getUsername();
  }

}
