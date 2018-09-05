package com.mgc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mgc.entity.system.SystemUser;

/**
 * 将JavaConfig拆分
 */
@Configuration
public class SystemConfig {
	// 显示装配bean
	@Bean
	public SystemUser systemUser(){
		return new SystemUser("test java config", "test java config");
	}
}
