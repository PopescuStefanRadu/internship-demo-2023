package com.example.secondProject.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailerServiceMailchimp implements Mailer {
    @Override
    public void mail(Object object) {
        log.info("Sending mail with Mailchimp");
    }
}
