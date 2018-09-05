package com.mgc.workflow;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
/**
 * 流程引擎事件监听器
 */
public class MyEventListener implements ActivitiEventListener{

	@Override
	public void onEvent(ActivitiEvent event) {
		// TODO Auto-generated method stub
		switch(event.getType()){
		case JOB_EXECUTION_SUCCESS:
			System.out.println("A job well done!");
			break;
		case JOB_EXECUTION_FAILURE:
			System.err.println("A job has failed...");
			break;
		default:
	        System.out.println("Event received: " + event.getType());
		}
	}

	@Override
	public boolean isFailOnException() {
		// TODO Auto-generated method stub
		return false;
	}

}
