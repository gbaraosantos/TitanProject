package com.baronhub.titan.project.configurations.session;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Session Listener
 */
public class SessionListener implements HttpSessionListener {
    private static Logger logger = Logger.getLogger(SessionListener.class.getName());
    private int sessionCount = 0;

    /**
     * Triggered whenever a new session is created
     * @param event HttpSessionEvent
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        synchronized (this) {
            sessionCount++;

            String ipAddress = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
            logger.log(Level.INFO, "New Session: " + ipAddress + " : Session Number" + sessionCount);

        }

        event.getSession().setMaxInactiveInterval(60 * 60);
    }

    /**
     * Triggered whenever a session is destroyed
     * @param event HttpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized (this) {   sessionCount--; }

    }
}
