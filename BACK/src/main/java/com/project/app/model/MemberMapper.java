package com.project.app.model;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface MemberMapper {

	// ID 중복검사
	MemberDTO selectOne (MemberDTO memberDTO);
	// 로그인
	MemberDTO selectOneLogin (MemberDTO memberDTO);
	
	// 회원 가입
	int insert (MemberDTO memberDTO);

	// 회원 탈퇴
	int delete (MemberDTO memberDTO);
	
}
