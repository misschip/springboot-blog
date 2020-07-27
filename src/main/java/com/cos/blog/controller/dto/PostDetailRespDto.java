package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 콤포지션은 되도록 하지 말기 - 필드명을 바로 써서 나중에 사용하기 편하게!

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDetailRespDto {
	private int id;
	private String title;
	private String content;
	private String username;
}
