package com.project.app.service;

import java.util.List;

import com.project.app.model.TodoDTO;

public interface TodoService {
	List<TodoDTO> selectAll(TodoDTO todoDTO);
	TodoDTO selectOne(TodoDTO todoDTO);
	boolean insert(TodoDTO todoDTO);
	boolean update(TodoDTO todoDTO);
	boolean delete(TodoDTO todoDTO);
}
