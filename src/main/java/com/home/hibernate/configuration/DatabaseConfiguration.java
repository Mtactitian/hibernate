package com.home.hibernate.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Bean
    @Qualifier(value = "inMemoryDb")
    public DataSource dataSourceProperties() {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .username("hibApp")
                .password("Password123-")
                .url("jdbc:h2:mem:testdb")
                .build();

        Resource initSchema = new ClassPathResource("scripts/schema-h2.sql");
        Resource initData = new ClassPathResource("scripts/data-h2.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(value = "inMemoryDb") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean container = new LocalContainerEntityManagerFactoryBean();
        container.setDataSource(dataSource);
        container.setPersistenceUnitName("Hibernate");
        container.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return container;
    }


    @Bean
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean bean) {
        return new JpaTransactionManager(bean.getObject());
    }
}