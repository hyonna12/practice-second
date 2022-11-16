package site.metacoding.second.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.dto.req.BoardReqDto.BoardSaveReqDto;
import site.metacoding.second.service.BoardService;

@RequiredArgsConstructor
@RestController
public class BoardController {

  final BoardService boardService;

  @PostMapping("/board")
  public String save(@RequestBody BoardSaveReqDto boardSaveReqDto) {
    boardService.save(boardSaveReqDto);
    return "ok";
  }

}
