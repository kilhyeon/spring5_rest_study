package spring5_rest_study.service;

import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;

@Service
public interface ModifyMemberService {
	int modifyMember(Member member);
}
