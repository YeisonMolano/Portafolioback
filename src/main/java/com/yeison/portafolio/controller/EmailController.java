package com.yeison.portafolio.controller;

import com.yeison.portafolio.modells.Email;
import com.yeison.portafolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@RequestMapping(path = "/email")
public class EmailController {
    @Autowired
    private EmailService sendMail;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public Email send(@RequestBody Email email){
        this.sendMail.sendMail(email);
        return email;
    }
}
