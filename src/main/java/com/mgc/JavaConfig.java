package com.mgc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mgc.entity.system.SystemUser;
import com.mgc.workflow.WorkFlow;

//@Configuration
// 自动扫描带@Component的bean 
//@ComponentScan("com.mgc.entity")
//@Import(SystemConfig.class)
//@ImportResource("classpath:applicationContext.xml")
public class JavaConfig {
	
	
	
	// 存在两个类型一样的bean时，注入的变量的名称必须和bean的id一样
//	@Bean
//	public SystemUser otherSystemUser(SystemUser su){
//		su.setAccount("other SystemUser");
//		su.setPassword("other SystemUser");
//		return su;
//	}
//	
//	@Bean
//	public WorkFlow workFlow(){
//		return new WorkFlow();
//	}
}
