package com.baronhub.titan.project.components.services.mailer;

import com.baronhub.titan.project.objects.email.Email;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

/**
 * Mailer Service Implementation
 */

@Transactional
@Service("Mailer")
public class MailerImpl implements Mailer{
    @Autowired private JavaMailSenderImpl mailer;
    private static Logger logger = Logger.getLogger(MailerImpl.class.getName());

    /**
     * @param fromAddress from Whom
     * @param toAddress to Whom
     * @param subject Email Subject
     * @param messageBody Message Body
     */
    @Override
    public void sendEmail(String fromAddress, String toAddress, String subject, String messageBody, String password) {
        try {
            new Email
                .EmailBuilder(mailer, fromAddress, toAddress, password)
                .setMessageBody(messageBody)
                .setSubject(subject)
                .build()
                .sendEmail();
        }catch (MessagingException exception) { logger.log(Level.ERROR, exception); }
    }
}
