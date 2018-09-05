package com.mgc.system;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mgc.dao.system.SystemUserDao;
import com.mgc.entity.system.SystemUser;

public class TestMybatis {
	private SqlSession sqlSession;
	Logger log = LoggerFactory.getLogger(TestMybatis.class);
	
	@Before
	public void before(){
//		try {
//			log.debug("slf4j log...");
//			InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//			sqlSession = sqlSessionFactory.openSession();
//		} catch (Exception e) {
//			log.debug("before", e);
//		}
	}
	
	@After
	public void after(){
//		sqlSession.commit();
//		sqlSession.close();
	}
	
	@Test
	public void test(){
//		SystemUserDao suDao = sqlSession.getMapper(SystemUserDao.class);
//		SystemUser su = new SystemUser("admin", "123456");
//		suDao.addSystemUser(su);
//		System.out.println(suDao.getSystemUsers().get(0).toString());
//		log.debug(suDao.getSystemUsers().get(0).toString());
	}
}
