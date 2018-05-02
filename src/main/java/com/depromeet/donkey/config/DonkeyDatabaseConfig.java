package com.depromeet.donkey.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "donkeyEntityManagerFactory",
    transactionManagerRef = "donkeyTransactionManager",
    basePackages = "com.depromeet.donkey.domain.donkey"
)
public class DonkeyDatabaseConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.donkey")
  public DataSource donkeyDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean donkeyEntityManagerFactory() {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

    factoryBean.setDataSource(donkeyDataSource());
    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    factoryBean.setPackagesToScan("com.depromeet.donkey.domain.donkey");

    return factoryBean;
  }

  @Bean
  public PlatformTransactionManager donkeyTransactionManager() {
    return new JpaTransactionManager(donkeyEntityManagerFactory().getObject());
  }
}
