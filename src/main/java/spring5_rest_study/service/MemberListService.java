package spring5_rest_study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;

@Service
public interface MemberListService {
	List<Member> getLists();
}
