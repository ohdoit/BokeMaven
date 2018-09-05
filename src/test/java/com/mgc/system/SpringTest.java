package com.mgc.system;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mgc.JavaConfig;
import com.mgc.common.MessageUtil;
import com.mgc.dao.system.SystemUserDao;
import com.mgc.entity.system.SystemUser;
import com.mgc.workflow.WorkFlow;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")//不能缺少classpath:
//@ContextConfiguration(classes=JavaConfig.class)
//@ActiveProfiles("dev")
public class SpringTest {
	

//	@Autowired
//	private SystemUser otherSystemUser;
//	
//	@Autowired
//	WorkFlow workFlow;
//
//	@Test
//	public void testJavaConfig(){
//		System.out.println("test java config : "+otherSystemUser.toString());
//	}
	
	//-------------------------------------------------------------------------
	@Autowired
	private SystemUserDao suDao;
	
	@Autowired
	private ApplicationContext applicationContext;
	
//	@Autowired
//	SpringProcessEngineConfiguration processEngineConfiguration;
	
	@Autowired
	ProcessEngineFactoryBean processEngine;
	
	@Autowired
	private TaskService taskService;
	
	@Test
	public void testXML(){
		List<SystemUser> suList = suDao.getSystemUsers();
		System.out.println("Spring 测试："+suList.size());
//		System.out.println("123 "+processEngineConfiguration==null);
		try {
			System.out.println("ProcessEngine name："+processEngine.getObject().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RepositoryService repositoryService = (RepositoryService)applicationContext.getBean("repositoryService");
		System.out.println("taskService: "+taskService.toString());

	}
	
}
