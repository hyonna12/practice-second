package site.metacoding.second.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

  private final EntityManager em;
  // db에서 들고온 데이터를 자바 오브젝트로 매핑

  public Board save(Board board) {
    em.persist(board);
    // persist - 데이터를 pc로 영속화해서 insert
    return board;
  }

  public List<Board> findAll() {
    List<Board> boardList = em.createQuery("select b from Board b", Board.class)
        .getResultList();
    return boardList;
  }

  public Optional<Board> findById(Integer boardId) {
    try {
      Optional<Board> boardOP = Optional
          .of(em.createQuery("select b from Board b where b.boardId =:boardId", Board.class)
              .setParameter("boardId", boardId)
              .getSingleResult());
      return boardOP;
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  public void deleteById(Integer boardId) {
    em.createQuery("delete from Board b where b.boardId = :boardId")
        .setParameter("boardId", boardId)
        .executeUpdate();
  }

}
