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
public class Board {
  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private Integer boardId;
  private String title;
  @Column(length = 1000)
  private String content;

  @Builder
  public Board(Integer boardId, String title, String content) {
    this.boardId = boardId;
    this.title = title;
    this.content = content;
  }

}
