package spring5_rest_study.mappers;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberMapperTest {
	protected static final Log log = LogFactory.getLog(MemberMapperTest.class);

	@Autowired
	private MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test03SelectMemberById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Member member = mapper.selectMemberById(15);
		Assert.assertNotNull(member);

		log.debug(member.toString());
	}

	@Test
	public void test01SelectMemberAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Member> list = mapper.selectMemberAll();
		Assert.assertNotNull(list);

		list.forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test02InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Member newMember = new Member("test99@test.com", "1111", "test99");

		int res = mapper.insertMember(newMember);
		Assert.assertEquals(1, res);
		
		mapper.deleteMember(newMember.getId());
	}

	@Test
	public void test04UpdateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Member newMember = new Member("test99@test.com", "2222", "테스트99");
		mapper.insertMember(newMember);
		
		newMember.setPassword("1111");
		int res = mapper.updateMember(newMember);
		Assert.assertEquals(1, res);
		
		mapper.deleteMember(newMember.getId());
	}

	@Test
	public void test05DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Member newMember = new Member("test99@test.com", "2222", "테스트99");
		mapper.insertMember(newMember);
		
		int res = mapper.deleteMember(newMember.getId());
		Assert.assertEquals(1, res);
	}

}
