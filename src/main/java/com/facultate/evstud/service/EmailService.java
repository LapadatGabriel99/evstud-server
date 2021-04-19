package com.facultate.evstud.service;

import com.facultate.evstud.mail.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String message) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setFrom("noreply@evstud.com");
        helper.setTo(to);
        helper.setSubject("Confirm your email");
        helper.setText(message, true);

        mailSender.send(mimeMessage);
    }
}
