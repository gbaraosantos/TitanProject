package com.baronhub.titan.project.components.services.mailer;

import com.baronhub.titan.project.objects.email.Email;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

/**
 * Mailer Service Implementation
 */

@Transactional
@Service("Mailer")
public class MailerImpl implements Mailer{
    @Autowired private JavaMailSender mailer;
    private static Logger logger = Logger.getLogger(MailerImpl.class.getName());


    @Override
    public void sendEmail(String fromAddress, String toAddress, String subject, String messageBody) {
        try {
            Email email = new Email
                    .EmailBuilder(this.mailer, fromAddress, toAddress)
                    .setMessageBody(messageBody)
                    .setSubject(subject)
                    .build();

            email.sendEmail();
        }catch (MessagingException exception) { logger.log(Level.ERROR, exception); }
    }
}
