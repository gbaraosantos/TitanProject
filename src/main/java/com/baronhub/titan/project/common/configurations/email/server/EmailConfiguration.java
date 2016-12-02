package com.baronhub.titan.project.common.configurations.email.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Email Server Configuration Based on .properties file
 */

@Configuration
@PropertySource(value = { "classpath:properties/EmailServer.properties" })
public class EmailConfiguration {
    @Autowired private Environment environment;

    /**
     * Configures Java email from Spring application
     * @return JavaMailSender email service provider
     */

    @Bean
    public JavaMailSenderImpl javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(environment.getRequiredProperty("email.host"));
        javaMailSender.setPort(Integer.parseInt(environment.getRequiredProperty("email.port")));

        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", environment.getRequiredProperty("mail.transport.protocol"));
        properties.setProperty("mail.smtp.auth", environment.getRequiredProperty("mail.smtp.auth"));
        properties.setProperty("mail.smtp.starttls.enable", environment.getRequiredProperty("mail.smtp.starttls.enable"));
        properties.setProperty("mail.debug", environment.getRequiredProperty("mail.debug"));
        return properties;
    }

}