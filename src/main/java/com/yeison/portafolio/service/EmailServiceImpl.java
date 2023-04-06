package com.yeison.portafolio.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.*;
import com.yeison.portafolio.modells.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl{
    private final static String MY_EMAIL = "Su correo";

    @Autowired
    private AmazonSimpleEmailServiceClient client;

    public void sendMessage(Email email) {
        Destination destination = new Destination()
                .withToAddresses(MY_EMAIL);

        Message message = new Message()
                .withSubject(new Content(email.getSubject().toUpperCase()))
                .withBody(new Body(new Content(email.getBody())));

        SendEmailRequest emailRequest = new SendEmailRequest()
                .withSource(MY_EMAIL)
                .withDestination(destination)
                .withMessage(message);

        client.sendEmail(emailRequest);
    }
}
