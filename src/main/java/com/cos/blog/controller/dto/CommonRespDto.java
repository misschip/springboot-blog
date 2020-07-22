package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 스프링에는 ResponseEntity라는 클래스를 미리 만들어 놓아서 이걸 사용하는 게 원칙인데
// 이걸 흉내내서 비슷하게 만들어 본 클래스임

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRespDto<T> {
	private int statusCode;	// 1:정상  -1:실패 0:변경안됨 // 원래는 enum으로 정리를 하는 게 좋음
	private T data;	// select 등의 경우에 반환 데이터 담는 용도
}
