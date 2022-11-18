package site.metacoding.second.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.dto.req.board.BoardReqDto.BoardSaveReqDto;
import site.metacoding.second.dto.req.board.BoardReqDto.BoardUpdateReqDto;
import site.metacoding.second.dto.resp.ResponseDto;
import site.metacoding.second.dto.resp.SessionUser;
import site.metacoding.second.dto.resp.board.BoardRespDto.BoardDetailRespDto;
import site.metacoding.second.dto.resp.board.BoardRespDto.BoardListRespDto;
import site.metacoding.second.dto.resp.board.BoardRespDto.BoardSaveRespDto;
import site.metacoding.second.dto.resp.board.BoardRespDto.BoardUpdateRespDto;
import site.metacoding.second.service.BoardService;

@RequiredArgsConstructor
@RestController
public class BoardController {

  private final BoardService boardService;
  private final HttpSession session;

  @PostMapping("/board")
  public ResponseDto<?> save(@RequestBody BoardSaveReqDto boardSaveReqDto) {
    SessionUser userPrincipal = (SessionUser) session.getAttribute("userPrincipal");
    if (userPrincipal != null) {
      boardSaveReqDto.setSessionUser(userPrincipal);
      BoardSaveRespDto boardSaveRespDto = boardService.save(boardSaveReqDto);
      return new ResponseDto<>(1, "게시글 등록", boardSaveRespDto);
    } else {
      throw new RuntimeException("로그인이 되어있지 않습니다.");
    }
  }

  @GetMapping("/board")
  public ResponseDto<?> findAll() {
    List<BoardListRespDto> boardListRespDtoList = boardService.findAll();
    return new ResponseDto<>(1, "게시글 목록", boardListRespDtoList);
  }

  @GetMapping("/board/{boardId}")
  public ResponseDto<?> findById(@PathVariable Integer boardId) {
    BoardDetailRespDto boardDetailRespDto = boardService.findById(boardId);
    return new ResponseDto<>(1, "게시글 상세보기", boardDetailRespDto);
  }

  @PutMapping("/board/{boardId}")
  public ResponseDto<?> update(@PathVariable Integer boardId, @RequestBody BoardUpdateReqDto boardUpdateReqDto) {
    SessionUser userPrincipal = (SessionUser) session.getAttribute("userPrincipal");
    if (userPrincipal != null) {
      boardUpdateReqDto.setSessionUser(userPrincipal);
      boardUpdateReqDto.setBoardId(boardId);
      BoardUpdateRespDto boardUpdateRespDto = boardService.update(boardUpdateReqDto);
      return new ResponseDto<>(1, "게시글 수정", boardUpdateRespDto);
    } else {
      throw new RuntimeException("로그인이 되어있지 않습니다.");
    }
  }

  @DeleteMapping("/board/{boardId}")
  public ResponseDto<?> delete(@PathVariable Integer boardId) {
    SessionUser userPrincipal = (SessionUser) session.getAttribute("userPrincipal");
    if (userPrincipal != null) {
      boardService.delete(boardId, userPrincipal);
      return new ResponseDto<>(1, "게시글 삭제", null);
    } else {
      throw new RuntimeException("로그인이 되어있지 않습니다.");
    }
  }

}
