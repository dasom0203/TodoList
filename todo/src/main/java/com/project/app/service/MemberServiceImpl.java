package com.project.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.model.MemberDTO;
import com.project.app.model.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<MemberDTO> selectAll(MemberDTO memberDTO) {
		// 기능 미사용으로 null 반환
		return null;
	}

	@Override
	public MemberDTO selectOne(MemberDTO memberDTO) {
		
		if(memberDTO.getMemberCondition()!=null && memberDTO.getMemberCondition().equals("MEMBER_ID_CHECK")) {
			// 회원가입 ID 체크
			return this.memberMapper.selectOne(memberDTO);
		}
		else if(memberDTO.getMemberCondition()!=null && memberDTO.getMemberCondition().equals("MEMBER_LOGIN")) {
			// 로그인 ID, PW 체크
			return this.memberMapper.selectOneLogin(memberDTO);
		}

		// 일치하는 컨디션이 없다면
		return null;
	}

	@Override
	public boolean insert(MemberDTO memberDTO) {
		boolean rs = true;

		int result = this.memberMapper.insert(memberDTO);

		// 만약 변경된 행이 없다면
		if(result <= 0) {
			rs = false;
		}

		return rs;

	}

	@Override
	public boolean update(MemberDTO memberDTO) {
		// 기능 미구현으로 false 반환
		return false;
	}

	@Override
	public boolean delete(MemberDTO memberDTO) {
		boolean rs = true;

		int result = this.memberMapper.delete(memberDTO);

		// 만약 변경된 행이 없다면
		if(result <= 0) {
			rs = false;
		}

		return rs;
	}

}
