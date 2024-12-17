package com.project.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	private String memberId; // 회원 ID 
	private String memberPassword; // 회원 PW
	private String memberName; // 회원 이름
	
	// DTO에만 있는 변수
	private String memberCondition; // 컨디션


}
