package spring5_rest_study.service;

import org.springframework.stereotype.Service;

@Service
public interface RemoveMemberService {
	int removeMember(long id);
}
