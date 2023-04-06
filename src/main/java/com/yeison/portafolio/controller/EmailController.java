package com.yeison.portafolio.controller;

import com.yeison.portafolio.modells.Email;
import com.yeison.portafolio.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/email")
public class EmailController {
    @Autowired
    private EmailServiceImpl sendMail;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Email send(@RequestBody Email email){
        this.sendMail.sendMessage(email);
        return email;
    }
}
