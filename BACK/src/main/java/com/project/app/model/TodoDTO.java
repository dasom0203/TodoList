package com.project.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoDTO {
	private int todoNum; // todo 번호 (PK)
	private String todoContent; // todo 내용
	private String todoStatus; // todo 상태 (완료, 미완료)
	private boolean todoImportant; // todo 중요 여부 (0(false), 1(true))
//	private String todoWriterId; // todo 작성자 ID (FK)
	
	// DTO에만 있는 변수
	private String todoCondition; // 컨디션
	
}
