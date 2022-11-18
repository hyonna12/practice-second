package site.metacoding.second.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ResponseDto<T> {
  Integer code;
  String msg;
  T data;

}
