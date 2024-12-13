package com.project.app.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface TodoMapper {

	// 일정 조회 (기본 : 미완료)
	List<TodoDTO> selectAll(TodoDTO todoDTO);
	// 일정 조회 (완료, 미완료, 전체)
	List<TodoDTO> selectAllFilter(TodoDTO todoDTO);
	
	// 일정 추가
	int insert(TodoDTO todoDTO);
	
	// 일정 수정 (내용, 중요 여부 수정)
	int update(TodoDTO todoDTO);
	// 일정 수정 (일정 상태 : 완료 ↔ 미완료)
	int updateStatus(TodoDTO todoDTO);
	
	// 일정 삭제
	int delete(TodoDTO todoDTO);
}
