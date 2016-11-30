package com.baronhub.titan.project.components.services.mailer;

/**
 * Mailer Interface
 */
public interface Mailer {
    void sendEmail(String fromAddress, String toAddress, String subject, String messageBody);
}
