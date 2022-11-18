package site.metacoding.second.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.dto.req.user.UserReqDto.UserJoinReqDto;
import site.metacoding.second.dto.req.user.UserReqDto.UserLoginReqDto;
import site.metacoding.second.dto.resp.ResponseDto;
import site.metacoding.second.dto.resp.SessionUser;
import site.metacoding.second.dto.resp.user.UserRespDto.UserJoinRespDto;
import site.metacoding.second.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserController {

  final UserService userService;

  @PostMapping("/join")
  public ResponseDto<?> join(@RequestBody UserJoinReqDto userJoinReqDto) {
    UserJoinRespDto userJoinRespDto = userService.join(userJoinReqDto);
    return new ResponseDto<>(1, "회원가입", userJoinRespDto);
  }

  @PostMapping("/login")
  public ResponseDto<?> login(@RequestBody UserLoginReqDto userLoginReqDto) {
    SessionUser sessionUser = userService.login(userLoginReqDto);
    return new ResponseDto<>(1, "로그인", sessionUser);
  }

  // @GetMapping("/board")
  // public ResponseDto<?> findAll() {
  // List<BoardListRespDto> boardListRespDtoList = boardService.findAll();
  // return new ResponseDto<>(1, "게시글 목록", boardListRespDtoList);
  // }

  // @GetMapping("/board/{boardId}")
  // public ResponseDto<?> findById(@PathVariable Integer boardId) {
  // BoardDetailRespDto boardDetailRespDto = boardService.findById(boardId);
  // return new ResponseDto<>(1, "게시글 상세보기", boardDetailRespDto);
  // }

  // @PutMapping("/board/{boardId}")
  // public ResponseDto<?> update(@PathVariable Integer boardId, @RequestBody
  // BoardUpdateReqDto boardUpdateReqDto) {
  // boardUpdateReqDto.setBoardId(boardId);
  // BoardUpdateRespDto boardUpdateRespDto =
  // boardService.update(boardUpdateReqDto);
  // return new ResponseDto<>(1, "게시글 수정", boardUpdateRespDto);
  // }

  // @DeleteMapping("/board/{boardId}")
  // public ResponseDto<?> delete(@PathVariable Integer boardId) {
  // boardService.delete(boardId);
  // return new ResponseDto<>(1, "게시글 삭제", null);
  // }

}
