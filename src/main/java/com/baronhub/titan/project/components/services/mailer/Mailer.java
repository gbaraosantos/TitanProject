package com.baronhub.titan.project.components.services.mailer;

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
    Boolean sendEmail(String fromAddress, List<String>  toAddresses, String subject, String messageBody, String password);
}
