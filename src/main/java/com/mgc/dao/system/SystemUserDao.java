package com.mgc.dao.system;

import java.util.List;

import com.mgc.entity.system.SystemUser;

public interface SystemUserDao {
	public List<SystemUser> getSystemUsers();
	
	public void save(SystemUser systemUser);
	
	public Integer saveAll0(List<SystemUser> systemList);
	
	public Integer saveAll(List<SystemUser> systemList);
	
	public Integer update(SystemUser systemUser);
	
	public List<SystemUser> getSystemUser(SystemUser systemUser);
	
	public List<SystemUser> findSystemUser(String account);
	
}
