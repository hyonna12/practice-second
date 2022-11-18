package site.metacoding.second.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.domain.Board;
import site.metacoding.second.domain.BoardRepository;
import site.metacoding.second.dto.req.board.BoardReqDto.BoardSaveReqDto;
import site.metacoding.second.dto.req.board.BoardReqDto.BoardUpdateReqDto;
import site.metacoding.second.dto.resp.board.BoardRespDto.BoardDetailRespDto;
import site.metacoding.second.dto.resp.board.BoardRespDto.BoardListRespDto;
import site.metacoding.second.dto.resp.board.BoardRespDto.BoardSaveRespDto;
import site.metacoding.second.dto.resp.board.BoardRespDto.BoardUpdateRespDto;

@RequiredArgsConstructor
@Service
public class BoardService {

  final BoardRepository boardRepository;

  @Transactional
  public BoardSaveRespDto save(BoardSaveReqDto boardSaveReqDto) {
    Board boardPS = boardRepository.save(boardSaveReqDto.toEntity());
    BoardSaveRespDto boardSaveRespDto = new BoardSaveRespDto(boardPS);
    return boardSaveRespDto;
  }

  @Transactional
  public List<BoardListRespDto> findAll() {
    List<Board> boardList = boardRepository.findAll();
    List<BoardListRespDto> boardListRespDtoList = new ArrayList<>();
    for (Board board : boardList) {
      boardListRespDtoList.add(new BoardListRespDto(board));
    }
    return boardListRespDtoList;
  }

  @Transactional
  public BoardDetailRespDto findById(Integer boardId) {
    Optional<Board> boardOP = boardRepository.findById(boardId);
    if (boardOP.isPresent()) {
      BoardDetailRespDto boardDetailRespDto = new BoardDetailRespDto(boardOP.get());
      return boardDetailRespDto;
    } else {
      throw new RuntimeException("해당 " + boardId + " 로 상세보기를 할 수 없습니다.");
    }

  }

  @Transactional
  public BoardUpdateRespDto update(BoardUpdateReqDto boardUpdateReqDto) {
    Optional<Board> boardOP = boardRepository.findById(boardUpdateReqDto.getBoardId());
    // JPA 의 영속성 컨텍스트 덕분에 entity 객체의 값만 변경하면 자동으로 변경사항 반영
    if (boardOP.isPresent()) {
      Board boardPS = boardOP.get();
      boardPS.update(boardUpdateReqDto.getTitle(), boardUpdateReqDto.getContent());
      BoardUpdateRespDto boardUpdateRespDto = new BoardUpdateRespDto(boardPS);
      return boardUpdateRespDto;
    } else {
      throw new RuntimeException("해당 " + boardUpdateReqDto.getBoardId() + " 로 수정할 수 없습니다.");
    }

  }

  @Transactional
  public void delete(Integer boardId) {
    Optional<Board> boardOP = boardRepository.findById(boardId);
    if (boardOP.isPresent()) {
      boardRepository.deleteById(boardId);
    } else {
      throw new RuntimeException("해당 " + boardId + " 로 삭제할 수 없습니다.");
    }

  }

}
