package com.baronhub.titan.project.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Email class
 */

public class Email {
    /*Mandatory Parameters*/
    private final JavaMailSender mailSender;
    private String fromAddress;
    private String toAddress;

    /*Optional Parameters*/
    private String subject;
    private String messageBody;


    public Email(EmailBuilder builder){
        this.mailSender = builder.mailSender;
        this.fromAddress = builder.fromAddress;
        this.toAddress = builder.toAddress;
        this.subject = builder.subject;
        this.messageBody = builder.messageBody;
    }

    public JavaMailSender getMailSender() { return mailSender; }
    public String getFromAddress() { return fromAddress; }
    public String getToAddress() { return toAddress; }
    public String getSubject() { return subject; }
    public String getMessageBody() { return messageBody; }


    /**
     * Builder for class email
     */
    public static class EmailBuilder{
        /*Mandatory Parameters*/
        private final JavaMailSender mailSender;

        private String fromAddress;
        private String toAddress;

        /*Optional Parameters*/
        private String subject;
        private String messageBody;

        public EmailBuilder(JavaMailSender mailSender, String fromAddress, String toAddress){
            this.mailSender = mailSender;
            this.fromAddress = fromAddress;
            this.toAddress = toAddress;
        }

        public EmailBuilder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailBuilder setMessageBody(String messageBody) {
            this.messageBody = messageBody;
            return this;
        }

        public Email build(){
            return new Email(this);
        }

    }


}
