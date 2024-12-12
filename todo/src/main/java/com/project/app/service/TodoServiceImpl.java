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

		if(todoDTO.getTodoCondition()!=null && todoDTO.getTodoCondition().equals("TODO_SELECTALL")) {
			// 일정 조회 (기본 - 미완료)
			return this.todoMapper.selectAll(todoDTO);

		}
		else if(todoDTO.getTodoCondition()!=null && todoDTO.getTodoCondition().equals("TODO_SELECTALL_FILTER")) {
			// 일정 조회 필터링 (완료, 미완료, 전체)
			return this.todoMapper.selectAllFilter(todoDTO);
		}

		// 일치하는 컨디션이 없다면
		return null;

	}

	@Override
	public TodoDTO selectOne(TodoDTO todoDTO) {
		return null; // 기능 미사용으로 null 반환
	}

	@Override
	public boolean insert(TodoDTO todoDTO) {
		boolean rs = true;

		int result=this.todoMapper.insert(todoDTO);

		// 만약 변경된 행이 없다면
		if(result <= 0) {
			rs = false;
		}

		return rs;
	}

	@Override
	public boolean update(TodoDTO todoDTO) {

		boolean rs = true;
		int result = 0;

		if(todoDTO.getTodoCondition()!=null && todoDTO.getTodoCondition().equals("TODO_UPDATE")) {
			// 일정 수정 (내용, 중요 여부 수정)
			result = this.todoMapper.update(todoDTO);
		}
		else if(todoDTO.getTodoCondition()!=null && todoDTO.getTodoCondition().equals("TODO_STATUS_UPDATE")) {
			// 일정 조회 필터링 (완료, 미완료, 전체)
			result = this.todoMapper.updateStatus(todoDTO);
		}
		else {
			// 일치하는 컨디션이 없다면
			return false;
		}

		// 만약 변경된 행이 없다면
		if(result <= 0) {
			rs = false;
		}

		return rs;

	}

	@Override
	public boolean delete(TodoDTO todoDTO) {
		boolean rs = true;

		int result = this.todoMapper.delete(todoDTO);

		// 만약 변경된 행이 없다면
		if(result <= 0) {
			rs = false;
		}

		return rs;
	}

}
