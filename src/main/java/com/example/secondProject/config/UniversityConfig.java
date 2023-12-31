package com.example.secondProject.config;

import com.example.secondProject.service.Mailer;
import com.example.secondProject.service.mailer.MailJet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Configuration
@Slf4j
public class UniversityConfig {

    @Bean(name = {"mailJet", "jetMail"}
//            autowireCandidate = false
    )
    @Scope(SCOPE_PROTOTYPE)
    @Profile("mailJet")
    public Mailer mailJet() {
        return new MailJet();
    }

    @Scheduled(cron = "0 * 12-20 * * *")
    public void runEveryMinBetween12PMAnd20PM() {
        log.info("hi from cron!");
    }
}
