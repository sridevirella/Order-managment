package com.egen;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/application.properties")
public class JPAConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		try {
			emf.setDataSource(dataSource());
			emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
			emf.setPackagesToScan("com.egen.model");
			emf.setJpaProperties(jpaProperties());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return emf;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.user"));
		ds.setPassword(env.getProperty("db.password"));
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {

		return new JpaTransactionManager((emf));
	}

	private Properties jpaProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
}