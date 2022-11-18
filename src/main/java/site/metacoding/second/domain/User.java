package site.metacoding.second.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

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
}
