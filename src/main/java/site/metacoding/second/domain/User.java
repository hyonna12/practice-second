package site.metacoding.second.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  Integer userId;
  @Column(unique = true)
  String username;
  String password;
  @Column(unique = true)
  String email;

  @Builder
  public User(Integer userId, String username, String password, String email) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.email = email;
  }

}
