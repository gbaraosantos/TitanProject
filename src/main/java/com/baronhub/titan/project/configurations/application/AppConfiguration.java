package com.baronhub.titan.project.configurations.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.IOException;

/**
 * Replaces web.xml
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.baronhub.titan.project")
@PropertySource(value = "classpath:properties/TitanProjectConfiguration.properties")
public class AppConfiguration extends WebMvcConfigurerAdapter {
    @Autowired private Environment environment;
    /**
     * Sets up the view Resolver for the Spring project
     * @return ViewResolver
     */

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(environment.getRequiredProperty("view.directory"));
        viewResolver.setSuffix(environment.getRequiredProperty("view.suffix"));
        return viewResolver;
    }

    /**
     * Maps the Multipart resolver for file upload
     * @return CommonsMultipartResolver
     * @throws IOException Exception
     */
    @Bean(name="multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(Integer.parseInt(environment.getRequiredProperty("resolver.maxUploadSize")));
        return resolver;
    }

    /**
     * Sets up the view Resolver for the Spring project
     * @return PropertySourcesPlaceholderConfigurer
     */

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
