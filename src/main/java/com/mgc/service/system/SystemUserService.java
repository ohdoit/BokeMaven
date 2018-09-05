package com.mgc.service.system;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.mgc.dao.system.SystemUserDao;
import com.mgc.entity.system.SystemUser;
@Service
public class SystemUserService {
	private Logger log = LoggerFactory.getLogger(SystemUserService.class);
	@Autowired
	private SystemUserDao suDao;
	
	@Autowired
	private ApplicationContext ac;
	
	public SystemUser login(SystemUser su, HttpSession session){
		log.debug(su.toString());
		List<SystemUser> suList = suDao.getSystemUser(su);
		if(suList.size()>0) return suList.get(0);
		else return null;
	}
	
	public SystemUser getSystemUser(String account){
		List<SystemUser> suList = suDao.findSystemUser(account);
		if(suList!=null && suList.size()>0){
			return suList.get(0);
		}else{
			return null;
		}
	}
	
	public void save(SystemUser su){
		suDao.save(su);
	}
	
	public boolean update(SystemUser su){
		return suDao.update(su)==null ? false : true;
	}
}
