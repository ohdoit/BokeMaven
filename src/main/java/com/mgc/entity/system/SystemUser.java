package com.mgc.entity.system;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mgc.entity.BaseEntity;
@Component
@Scope("session")
public class SystemUser extends BaseEntity{
	private String account;
	
	private String password;

	//必须提供无参构造器
	public SystemUser(){}
	
	public SystemUser(String account, String password){
		this.account = account;
		this.password = password;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString(){
		return "account: "+this.account+", password: "+this.password;
	}
}
