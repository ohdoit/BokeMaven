package com.mgc.workflow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class WorkFlow {
	private ProcessEngine processEngine;
	public WorkFlow(){
//		ProcessEngineConfiguration cfg = ProcessEngineConfiguration
//				.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
//		processEngine = cfg.buildProcessEngine();
		// This will look for an activiti.cfg.xml file on the classpath and 
		// construct an engine based on the configuration in that file. 
//		processEngine = ProcessEngines.getDefaultProcessEngine();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ComboPooledDataSource ds = (ComboPooledDataSource)ctx.getBean("dataSource");
		processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
				.setJdbcDriver(ds.getDriverClass())
				.setJdbcUrl(ds.getJdbcUrl())
				.setJdbcUsername(ds.getUser())
				.setJdbcPassword(ds.getPassword())
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
				.setAsyncExecutorActivate(false).buildProcessEngine();
	}
	
	public ProcessEngine getProcessEngine() {
		return processEngine;
	}

}
