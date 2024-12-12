package com.project.app.model;

public class TodoDTO {


	private int todoNum; // todo 번호 (PK)
	private String todoContent; // todo 내용
	private String todoStatus; // todo 상태 (완료, 미완료)
	private boolean todoImportant; // todo 중요 여부 (0(false), 1(true))
	private String todoWriterId; // todo 작성자 ID (FK)
	
	// DTO에만 있는 변수
	private String todoCondition; // 컨디션

	
	
	public int getTodoNum() {
		return todoNum;
	}

	public void setTodoNum(int todoNum) {
		this.todoNum = todoNum;
	}

	public String getTodoContent() {
		return todoContent;
	}

	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}

	public String getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}

	public boolean isTodoImportant() {
		return todoImportant;
	}

	public void setTodoImportant(boolean todoImportant) {
		this.todoImportant = todoImportant;
	}

	public String getTodoWriterId() {
		return todoWriterId;
	}

	public void setTodoWriterId(String todoWriterId) {
		this.todoWriterId = todoWriterId;
	}

	public String getTodoCondition() {
		return todoCondition;
	}

	public void setTodoCondition(String todoCondition) {
		this.todoCondition = todoCondition;
	}

	@Override
	public String toString() {
		return "TodoDTO [todoNum=" + todoNum + ", todoContent=" + todoContent + ", todoStatus=" + todoStatus
				+ ", todoImportant=" + todoImportant + ", todoWriterId=" + todoWriterId + ", todoCondition="
				+ todoCondition + "]";
	}
	
	
	
}
