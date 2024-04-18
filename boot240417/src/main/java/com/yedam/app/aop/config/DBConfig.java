package com.yedam.app.aop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configurable
@EnableTransactionManagement // bean 등록시 필요
public class DBConfig {
	//private final DataSource datasource;
	
	@Bean
	public TransactionManager transactionManager(DataSource datasource) {
		return new DataSourceTransactionManager(datasource);
	}
}
