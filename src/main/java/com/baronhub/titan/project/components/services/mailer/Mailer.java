package com.baronhub.titan.project.components.services.mailer;

/**
 * Mailer Interface
 */
@FunctionalInterface
public interface Mailer {

    /**
     * @param fromAddress from Whom
     * @param toAddress to Whom
     * @param subject Email Subject
     * @param messageBody Message Body
     */
    void sendEmail(String fromAddress, String toAddress, String subject, String messageBody);
}
