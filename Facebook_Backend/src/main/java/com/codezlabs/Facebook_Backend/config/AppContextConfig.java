package com.codezlabs.Facebook_backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.codezlabs.Facebook_backend")
public class AppContextConfig {
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("social");
		dataSource.setPassword("social");
		return dataSource;
	}

	@Autowired
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(gethibernateProperties());
		sessionFactory.setPackagesToScan(new String[] {"com.codezlabs.Facebook_backend.model"});
		return sessionFactory;
		
	}
	
	@Autowired
	@Bean(name="transactionManger")
	public HibernateTransactionManager getHibernateTransactionManger(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager= new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
		
	}

	private Properties gethibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show.sql","true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}
