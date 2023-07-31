package com.example.secondProject.service.mailer;

import com.example.secondProject.service.Mailer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;

@Slf4j
public class MailJet implements Mailer {
    @Override
    public void mail(Object object) {
        log.info("sending mail from mailJET");
    }


}
