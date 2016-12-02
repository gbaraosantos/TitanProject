package com.baronhub.titan.project.configurations.storage.databases.relational;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Hibernate Configuration for relational Database
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.baronhub.titan.project.configurations"})
@PropertySource(value = {"classpath:properties/Database.properties"})
public class Hibernate {

    @Autowired private Environment environment;

    /**
     * @return LocalSessionFactoryBean
     */

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.baronhub.titan.project.components.models");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    /**
     * @return DataSource
     */

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(urlBuilder());
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();

        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.connection.CharSet", environment.getRequiredProperty("hibernate.connection.CharSet"));
        properties.put("hibernate.connection.characterEncoding", environment.getRequiredProperty("hibernate.connection.characterEncoding"));
        properties.put("hibernate.connection.useUnicode", environment.getRequiredProperty("hibernate.connection.useUnicode"));

        return properties;
    }

    /**
     * @param s SessionFactory
     * @return HibernateTransactionManager
     */

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    private String urlBuilder(){
        return environment.getRequiredProperty("jdbc.url")                                                      +
                "?"     + "autoReconnect="          + environment.getRequiredProperty("autoReconnect")          +
                "&"     + "useSSL="                 + environment.getRequiredProperty("useSSL")                 +
                "&"     + "maxReconnects="          + environment.getRequiredProperty("maxReconnects")          +
                "&"     + "initialTimeout="         + environment.getRequiredProperty("initialTimeout")         +
                "&"     + "useUnicode="             + environment.getRequiredProperty("useUnicode")             +
                "&amp;" + "characterEncoding"       + environment.getRequiredProperty("characterEncoding");
    }
}
