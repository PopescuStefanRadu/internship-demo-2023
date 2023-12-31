package com.example.secondProject.service.mailer;


import com.example.secondProject.service.Mailer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("mailchimp")
public class MailerServiceMailchimp implements Mailer {
    @Override
    public void mail(Object object) {
        log.info("Sending mail with Mailchimp");
    }
}
