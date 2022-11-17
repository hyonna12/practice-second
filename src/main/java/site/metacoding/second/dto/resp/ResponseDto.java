package site.metacoding.second.dto.resp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto<T> {
  Integer code;
  String msg;
  T data;

  public ResponseDto(Integer code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

}
