package spring5_rest_study.service.impl;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mappers.MemberMapper;
import spring5_rest_study.service.GetMemberService;

@Service
public class GetMemberServiceImpl implements GetMemberService {
	static final Log log = LogFactory.getLog(MemberListServiceImpl.class);

	@Autowired
	private MemberMapper mapper;

	@Override
	public Member getMember(long id) {
		log.debug("service - getMember() > " + id);
		return mapper.selectMemberById(id);

	}

}
