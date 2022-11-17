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
  public BoardUpdateRespDto update(BoardUpdateReqDto boardUpdateReqDto) {
    Board boardPS = boardRepository.save(boardUpdateReqDto.toEntity());
    BoardUpdateRespDto boardUpdateRespDto = new BoardUpdateRespDto(boardPS);
    return boardUpdateRespDto;
  }

}
