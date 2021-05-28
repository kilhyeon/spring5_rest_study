package spring5_rest_study.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;
import spring5_rest_study.dto.Member;
import spring5_rest_study.mappers.MemberMapperTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberListServiceTest {
	protected static final Log log = LogFactory.getLog(MemberMapperTest.class);

	@Autowired
	private MemberListService service;

	@Test
	public void testGetLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Member> list = service.getLists();
		Assert.assertNotNull(list);

		list.forEach(s -> log.debug(s.toString()));
	}

}
