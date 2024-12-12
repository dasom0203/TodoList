package com.project.app.service;

import java.util.List;

import com.project.app.model.MemberDTO;

public interface MemberService {

	List<MemberDTO> selectAll (MemberDTO memberDTO);
	MemberDTO selectOne (MemberDTO memberDTO);
	boolean insert (MemberDTO memberDTO);
	boolean update (MemberDTO memberDTO);
	boolean delete (MemberDTO memberDTO);
}
