package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRespDto<T> {
	private int statusCode;	// 1:정상  -1:실패 0:변경안됨 // 원래는 enum으로 정리를 하는 게 좋음
	private T data;	// select 등의 경우에 반환 데이터 담는 용도
}
