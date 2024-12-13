package com.project.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.model.TodoDTO;
import com.project.app.model.TodoMapper;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoMapper todoMapper;

	@Override
	public List<TodoDTO> selectAll(TodoDTO todoDTO) {

		System.out.println("========== com.project.app.service selectAll 시작 ==========");

		
		System.out.println("=== com.project.app.service selectAll condition 확인 ["+todoDTO.getTodoCondition()+"]===");
		
		
		if(todoDTO.getTodoCondition()!=null && todoDTO.getTodoCondition().equals("TODO_SELECTALL")) {
			System.out.println("=== com.project.app.service selectAll 일정조회 : 기본 ===");
			todoDTO.setTodoStatus("미완료");
			
			// 일정 조회 (기본 - 미완료)
			return this.todoMapper.selectAll(todoDTO);

		}
		else if(todoDTO.getTodoCondition()!=null && todoDTO.getTodoCondition().equals("TODO_SELECTALL_FILTER")) {
			System.out.println("=== com.project.app.service selectAll 일정조회 : 필터링 ===");
			
			// 일정 조회 필터링 (완료, 미완료, 전체)
			return this.todoMapper.selectAllFilter(todoDTO);
		}

		// 데이터 로그

		System.err.println("========== com.project.app.service selectAll 일치하는 컨디션 없음 ==========");

		// 일치하는 컨디션이 없다면
		return null;

	}

	@Override
	public TodoDTO selectOne(TodoDTO todoDTO) {
		return null; // 기능 미사용으로 null 반환
	}

	@Override
	public boolean insert(TodoDTO todoDTO) {
		
		System.out.println("========== com.project.app.service insert 시작 ==========");

		boolean rs = true;

		int result=this.todoMapper.insert(todoDTO);

		System.out.println("=== com.project.app.service selectAll result ["+result+"]===");

		// 만약 변경된 행이 없다면
		if(result <= 0) {
			System.err.println("=== com.project.app.service selectAll 변경된 행 없음===");

			rs = false;
		}
		
		System.out.println("========== com.project.app.service insert 종료 ==========");

		return rs;
	}

	@Override
	public boolean update(TodoDTO todoDTO) {

		System.out.println("========== com.project.app.service update 시작 ==========");

		boolean rs = true;
		int result = 0;
		
		System.out.println("=== com.project.app.service update condition ["+todoDTO.getTodoCondition()+"]===");


		if(todoDTO.getTodoCondition()!=null && todoDTO.getTodoCondition().equals("TODO_UPDATE")) {
			
			System.out.println("=== com.project.app.service update 일정 수정 (내용, 중요 여부) ===");

			// 일정 수정 (내용, 중요 여부 수정)
			result = this.todoMapper.update(todoDTO);
		}
		else if(todoDTO.getTodoCondition()!=null && todoDTO.getTodoCondition().equals("TODO_STATUS_UPDATE")) {
			
			System.out.println("=== com.project.app.service update 일정 상태 변경 ===");

			// 일정 상태 변경 (완료, 미완료)
			result = this.todoMapper.updateStatus(todoDTO);
		}
		else {
			System.err.println("=== com.project.app.service update 일치하는 컨디션 없음 ===");

			// 일치하는 컨디션이 없다면
			return false;
		}

		System.err.println("=== com.project.app.service update result ["+result+"]===");

		// 만약 변경된 행이 없다면
		if(result <= 0) {
			
			System.err.println("=== com.project.app.service update 변경된 행 없음===");

			rs = false;
		}

		System.out.println("========== com.project.app.service update 종료 ==========");

		return rs;

	}

	@Override
	public boolean delete(TodoDTO todoDTO) {
		
		System.out.println("========== com.project.app.service delete 시작 ==========");

		boolean rs = true;

		int result = this.todoMapper.delete(todoDTO);

		System.err.println("=== com.project.app.service delete result ["+result+"]===");

		// 만약 변경된 행이 없다면
		if(result <= 0) {
			rs = false;
		}

		System.out.println("========== com.project.app.service delete 종료 ==========");

		return rs;
	}

}
