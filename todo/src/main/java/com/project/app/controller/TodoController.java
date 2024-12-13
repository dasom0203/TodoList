package com.project.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.model.TodoDTO;
import com.project.app.service.TodoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/todo")
@Tag(name="Todo Controller", description="Todo 컨트롤러입니다.")
public class TodoController {

	@Autowired
	private TodoService todoService;


	// [POST] /todo : 일정 추가
	@PostMapping
	public ResponseEntity<Boolean> todoInsert(@RequestBody TodoDTO todoDTO) {
		System.out.println("*****com.project.app.controller todoInsert 시작 *****");
		// Service에 객체를 보내 결과를 반환한다
		boolean response = todoService.insert(todoDTO);

		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);

	}

	// [GET] /todo/{todoWriterId}  *일정 조회 (기본 - 미완료)
	@GetMapping
	public ResponseEntity<List<TodoDTO>> todoSelectAll (TodoDTO todoDTO){


		// 기능 구분을 위한 컨디션 set
		todoDTO.setTodoCondition("TODO_SELECTALL");
//		// 경로에서 받은 데이터를 DTO에 반영
//		todoDTO.setTodoWriterId(todoWriterId);


		// Service에 객체를 보내 결과 반환
		List<TodoDTO> response = todoService.selectAll(todoDTO);

		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);
	}


	// [GET] /todo/{todoWriterId}/{todoStatus}  *일정 조회 필터링 (전체, 완료, 미완료)
	@GetMapping("/filter")
	public ResponseEntity<List<TodoDTO>> todoSelectAllFilter( @RequestParam String todoStatus, TodoDTO todoDTO){

		// 기능 구분을 위한 컨디션 set
		todoDTO.setTodoCondition("TODO_SELECTALL_FILTER");
		// 경로에서 받은 데이터를 DTO에 반영
//		todoDTO.setTodoWriterId(todoWriterId);
		todoDTO.setTodoStatus(todoStatus);


		// Service에 객체를 보내 결과 반환
		List<TodoDTO> response = todoService.selectAll(todoDTO);

		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);
	}



	// [PUT] /todo  *일정 수정 (내용, 중요여부 수정)
	@PutMapping
	public ResponseEntity<Boolean> todoUpdate(@RequestBody TodoDTO todoDTO){

		// Mapper 구분을 위한 컨디션
		todoDTO.setTodoCondition("TODO_UPDATE");

		// Service에 객체를 보내 결과를 반환한다
		boolean response = todoService.update(todoDTO);

		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);
	}


	// [PUT] /todo/status  *일정 수정 (체크박스 완료 ↔ 미완료)
	@PutMapping("/status")
	public ResponseEntity<Boolean> todoUpdateStatus(@RequestBody TodoDTO todoDTO){

		// Mapper 구분을 위한 컨디션
		todoDTO.setTodoCondition("TODO_STATUS_UPDATE");

		// Service에 객체를 보내 결과를 반환한다
		boolean response = todoService.update(todoDTO);

		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);
	}


	// [DELETE] /todo/{todoNum}  *일정 삭제
	@DeleteMapping ("/{todoNum}")
	public ResponseEntity<Boolean> todoDelete (@PathVariable int todoNum, TodoDTO todoDTO){

		// 경로에서 받은 데이터를 DTO에 반영
		todoDTO.setTodoNum(todoNum);

		// Service에 객체를 보내 결과 반환
		boolean response = todoService.delete(todoDTO);

		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);

	}


}
