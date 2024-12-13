package com.project.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.model.MemberDTO;
import com.project.app.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// [POST] /member *회원가입
	@PostMapping
	public ResponseEntity<Boolean> memberInsert(@RequestBody MemberDTO memberDTO){

		// Service에 객체를 보내 결과를 반환한다
		boolean response = memberService.insert(memberDTO);

		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);
	}


	// [POST] /member/idCheck  * ID 중복검사
	@PostMapping("/idCheck")
	public ResponseEntity<MemberDTO> memberIdCheck(@RequestBody MemberDTO memberDTO){
		
		// Mapper 구분을 위한 컨디션
		memberDTO.setMemberCondition("MEMBER_ID_CHECK");
		
		// Service에 객체를 보내 결과 반환
		MemberDTO response = memberService.selectOne(memberDTO);
		
		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);
	}
	
	// [POST] /member/login  * 로그인
	@PostMapping("/login")
	public ResponseEntity<MemberDTO> memberLogin(@RequestBody MemberDTO memberDTO){
		
		// Mapper 구분을 위한 컨디션
		memberDTO.setMemberCondition("MEMBER_LOGIN");
		
		// Service에 객체를 보내 결과 반환
		MemberDTO response = memberService.selectOne(memberDTO);
		
		
		// HTTP 상태 코드와 함께 결과 반환
		return ResponseEntity.ok(response);
	}

}
