package com.baronhub.titan.project.components.services.mailer;

import com.baronhub.titan.project.common.objects.email.Email;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.List;

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
     * @param toAddresses to Whom
     * @param subject Email Subject
     * @param messageBody Message Body
     */
    @Override
    public Boolean sendEmail(String fromAddress, List<String> toAddresses, String subject, String messageBody, String password) {
        try {
            for (String toAddress : toAddresses) {
                new Email
                    .EmailBuilder(mailer, fromAddress, toAddress, password)
                    .setMessageBody(messageBody)
                    .setSubject(subject)
                    .build().sendEmail();
            }
            return true;

        }catch (MessagingException exception) {
            logger.log(Level.ERROR, exception);
            return false;
        }
    }
}
