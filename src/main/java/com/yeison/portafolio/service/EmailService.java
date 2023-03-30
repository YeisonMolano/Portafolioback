package com.yeison.portafolio.service;

import com.yeison.portafolio.modells.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(Email email) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom("kolokololoco79@gmail.com");
        mail.setTo("yhariib@gmail.com");
        mail.setSubject(email.getSubject());
        mail.setText(email.getBody());

        javaMailSender.send(mail);
    }
}
