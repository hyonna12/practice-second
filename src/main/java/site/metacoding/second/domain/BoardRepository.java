package site.metacoding.second.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.dto.req.BoardReqDto.BoardSaveReqDto;

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

}
