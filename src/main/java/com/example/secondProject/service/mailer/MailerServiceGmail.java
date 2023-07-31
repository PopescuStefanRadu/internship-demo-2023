package com.example.secondProject.service.mailer;


import com.example.secondProject.config.MailerConfigurationProperties;
import com.example.secondProject.service.Mailer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Primary
@Profile("gmail")
@RequiredArgsConstructor
public class MailerServiceGmail implements Mailer {
    private final MailerConfigurationProperties properties;

    @Override
    public void mail(Object object) {
        log.info("Sending mail with Gmail");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Gmail mailer postConstruct: {}", properties);
    }
}
