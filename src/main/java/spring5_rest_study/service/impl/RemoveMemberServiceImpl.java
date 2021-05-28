package spring5_rest_study.service.impl;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.mappers.MemberMapper;
import spring5_rest_study.service.RemoveMemberService;

@Service
public class RemoveMemberServiceImpl implements RemoveMemberService {
	static final Log log = LogFactory.getLog(MemberListServiceImpl.class);

	@Autowired
	private MemberMapper mapper;

	@Override
	public int removeMember(long id) {
		log.debug("service - removeMemberByNo() > " + id);
		return mapper.deleteMember(id);
	}

}
