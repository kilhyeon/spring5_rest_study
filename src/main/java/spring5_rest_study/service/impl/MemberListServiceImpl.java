package spring5_rest_study.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Member;
import spring5_rest_study.mappers.MemberMapper;
import spring5_rest_study.service.MemberListService;

@Service
public class MemberListServiceImpl implements MemberListService {
	static final Log log = LogFactory.getLog(MemberListServiceImpl.class);

	@Autowired
	private MemberMapper mapper;

	@Override
	public List<Member> getLists() {
		List<Member> list = mapper.selectMemberAll();
		log.debug("service - getLists() > " + list.size());
		return list;
	}

}
