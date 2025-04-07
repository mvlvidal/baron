package br.com.baron.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactoryBaron",
		transactionManagerRef = "transactionManagerBaron",
		basePackages = { "br.com.baron.repository"}
)
public class BaronConfig {
	@Bean(name="dataSourceBaron")
	@ConfigurationProperties(prefix = "baron.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
		
	@Bean(name = "entityManagerFactoryBaron")
	public LocalContainerEntityManagerFactoryBean 
		entityManagerFactory(
		EntityManagerFactoryBuilder builder,
		@Qualifier("dataSourceBaron") DataSource dataSource
	  ) {
	return builder
	      .dataSource(dataSource)
	      .packages("br.com.baron.model")
	      .persistenceUnit("baron")
	      .build();
	}
	    
	@Bean(name = "transactionManagerBaron")
	public PlatformTransactionManager transactionManager(
	  @Qualifier("entityManagerFactoryBaron") EntityManagerFactory 
	  entityManagerFactory
	) {
	  return new JpaTransactionManager(entityManagerFactory);
	}
}
