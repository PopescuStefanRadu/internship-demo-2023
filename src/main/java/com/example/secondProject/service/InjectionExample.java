package com.example.secondProject.service;

import com.example.secondProject.config.MailerConfigurationProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class InjectionExample {
    private final List<Mailer> allMailers;
    @Qualifier("mailerServiceMailchimp")
    private final Mailer mailchimp;
    @Qualifier("mailerServiceGmail")
    private final Mailer gmail;
    private final Mailer defaultMailer;
    private final Map<String, Mailer> mailersByBeanName;
    private final ApplicationContext context;

    @Value("#{mailerConfigurationProperties.gmailMailConfig.enableSMTP}")
    private final Boolean enableSMTP;


    @Value("${USERNAME:test}") // ce e intre () e SpEL
    private final String envVarUsername;

    @PostConstruct
    public void postConstruct() {
        // Constructor bean1
        // PostConstruct bean1
        // Constructor bean2
        // PostConstruct bean2

        // Constructor bean1
        // Constructor bean2
        // PostConstruct bean1
        // PostConstruct bean2

        log.info("StudentService#postConstruct, enableSMTP: {}, username: {}", enableSMTP, envVarUsername);


        allMailers.forEach(mailer -> mailer.mail(null));
    }

    @PreDestroy
    public void preDestroy() {
        log.info("");
    }

}
