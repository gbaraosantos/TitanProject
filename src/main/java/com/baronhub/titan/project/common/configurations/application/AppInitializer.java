package com.baronhub.titan.project.common.configurations.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionTrackingMode;
import java.util.HashSet;

/**
 * Replaces dispatcherServlet.xml
 */
@ComponentScan(basePackages = "com.baronhub.titan.project")
public class AppInitializer implements WebApplicationInitializer {

    /**
     * Application Startup
     * @param  container initializes servlet context
     */
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfiguration.class);
        ctx.setServletContext(container);
        ctx.refresh();

        container.addListener(new ContextLoaderListener(ctx));
        container.setInitParameter("defaultHtmlEscape", "true");

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        /* <!-- Disables URL-based sessions --> */
        HashSet<SessionTrackingMode> set = new HashSet<>();
        set.add(SessionTrackingMode.COOKIE);
        container.setSessionTrackingModes(set);
    }
}
