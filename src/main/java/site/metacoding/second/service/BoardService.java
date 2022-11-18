package site.metacoding.second.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.domain.Board;
import site.metacoding.second.domain.BoardRepository;
import site.metacoding.second.dto.req.BoardReqDto.BoardSaveReqDto;
import site.metacoding.second.dto.req.BoardReqDto.BoardUpdateReqDto;
import site.metacoding.second.dto.resp.BoardRespDto.BoardDetailRespDto;
import site.metacoding.second.dto.resp.BoardRespDto.BoardListRespDto;
import site.metacoding.second.dto.resp.BoardRespDto.BoardSaveRespDto;
import site.metacoding.second.dto.resp.BoardRespDto.BoardUpdateRespDto;

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
    Board boardPS = boardRepository.findById(boardId);
    BoardDetailRespDto boardDetailRespDto = new BoardDetailRespDto(boardPS);
    return boardDetailRespDto;
  }

  @Transactional
  public BoardUpdateRespDto update(Integer boardId, BoardUpdateReqDto boardUpdateReqDto) {
    Board boardPS = boardRepository.findById(boardId);
    // JPA 의 영속성 컨텍스트 덕분에 entity 객체의 값만 변경하면 자동으로 변경사항 반영
    // 따라서 repository.update 를 쓰지 않아도 됨.
    boardPS.update(boardUpdateReqDto.getTitle(), boardUpdateReqDto.getContent());
    BoardUpdateRespDto boardUpdateRespDto = new BoardUpdateRespDto(boardPS);
    return boardUpdateRespDto;
  }

  @Transactional
  public void delete(Integer boardId) {
    boardRepository.deleteById(boardId);
  }

}
