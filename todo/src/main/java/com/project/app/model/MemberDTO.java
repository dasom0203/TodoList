package com.project.app.model;

public class MemberDTO {
	private String memberId; // 회원 ID 
	private String memberPassword; // 회원 PW
	private String memberName; // 회원 이름
	
	// DTO에만 있는 변수
	private String memberCondition; // 컨디션

	
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberCondition() {
		return memberCondition;
	}

	public void setMemberCondition(String memberCondition) {
		this.memberCondition = memberCondition;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ ", memberCondition=" + memberCondition + "]";
	}
	
}
