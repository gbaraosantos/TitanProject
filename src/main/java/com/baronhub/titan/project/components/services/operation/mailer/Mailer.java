package com.baronhub.titan.project.components.services.operation.mailer;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Mailer Interface
 */
@FunctionalInterface
public interface Mailer {

    /**
     * @param fromAddress from Whom
     * @param toAddresses to Whom
     * @param subject Email Subject
     * @param messageBody Message Body
     * @param password password
     * @return Boolean Success Handler
     */
    void sendEmail(String fromAddress, List<String>  toAddresses, String subject, String messageBody, String password) throws MessagingException;
}
