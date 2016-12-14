package com.baronhub.titan.project.components.services.operation.mailer;

import com.baronhub.titan.project.common.objects.email.Email;
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

    /**
     * @param fromAddress from Whom
     * @param toAddresses to Whom
     * @param subject Email Subject
     * @param messageBody Message Body
     */
    @Override
    public void sendEmail(String fromAddress, List<String> toAddresses, String subject, String messageBody, String password) throws MessagingException {
        for (String toAddress : toAddresses) {
            new Email.EmailBuilder(mailer, fromAddress, toAddress, password)
                    .setMessageBody(messageBody)
                    .setSubject(subject)
                    .build()
                .sendEmail();
        }
    }
}
