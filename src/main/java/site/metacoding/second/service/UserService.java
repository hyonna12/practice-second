package site.metacoding.second.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.domain.User;
import site.metacoding.second.domain.UserRepository;
import site.metacoding.second.dto.req.user.UserReqDto.UserJoinReqDto;
import site.metacoding.second.dto.req.user.UserReqDto.UserLoginReqDto;
import site.metacoding.second.dto.resp.SessionUser;
import site.metacoding.second.dto.resp.user.UserRespDto.UserJoinRespDto;

@RequiredArgsConstructor
@Service
public class UserService {

  final UserRepository userRepository;

  @Transactional
  public UserJoinRespDto join(UserJoinReqDto userJoinReqDto) {
    User userPS = userRepository.save(userJoinReqDto.toEntity());
    UserJoinRespDto userJoinRespDto = new UserJoinRespDto(userPS);
    return userJoinRespDto;
  }

  @Transactional
  public SessionUser login(UserLoginReqDto userLoginReqDto) {
    Optional<User> userOP = userRepository.findByUsername(userLoginReqDto.getUsername());
    if (userOP.isPresent() && userOP.get().getPassword().equals(userLoginReqDto.getPassword())) {
      SessionUser sessionUser = new SessionUser(userOP.get());
      return sessionUser;
    } else {
      throw new RuntimeException("아이디 혹은 비밀번호가 일치하지 않습니다.");
    }
  }

  // @Transactional
  // public List<BoardListRespDto> findAll() {
  // List<Board> boardList = boardRepository.findAll();
  // List<BoardListRespDto> boardListRespDtoList = new ArrayList<>();
  // for (Board board : boardList) {
  // boardListRespDtoList.add(new BoardListRespDto(board));
  // }
  // return boardListRespDtoList;
  // }

  // @Transactional
  // public BoardDetailRespDto findById(Integer boardId) {
  // Optional<Board> boardOP = boardRepository.findById(boardId);
  // if (boardOP.isPresent()) {
  // BoardDetailRespDto boardDetailRespDto = new
  // BoardDetailRespDto(boardOP.get());
  // return boardDetailRespDto;
  // } else {
  // throw new RuntimeException("해당 " + boardId + " 로 상세보기를 할 수 없습니다.");
  // }
  // }

  // @Transactional
  // public BoardUpdateRespDto update(BoardUpdateReqDto boardUpdateReqDto) {
  // Optional<Board> boardOP =
  // boardRepository.findById(boardUpdateReqDto.getBoardId());
  // // JPA 의 영속성 컨텍스트 덕분에 entity 객체의 값만 변경하면 자동으로 변경사항 반영
  // if (boardOP.isPresent()) {
  // Board boardPS = boardOP.get();
  // boardPS.update(boardUpdateReqDto.getTitle(), boardUpdateReqDto.getContent());
  // BoardUpdateRespDto boardUpdateRespDto = new BoardUpdateRespDto(boardPS);
  // return boardUpdateRespDto;
  // } else {
  // throw new RuntimeException("해당 " + boardUpdateReqDto.getBoardId() + " 로 수정할 수
  // 없습니다.");
  // }
  // }

  // @Transactional
  // public void delete(Integer boardId) {
  // Optional<Board> boardOP = boardRepository.findById(boardId);
  // if (boardOP.isPresent()) {
  // boardRepository.deleteById(boardId);
  // } else {
  // throw new RuntimeException("해당 " + boardId + " 로 삭제할 수 없습니다.");
  // }
  // }

}
