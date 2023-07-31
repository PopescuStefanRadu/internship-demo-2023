package com.example.secondProject.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Configuration
@ConfigurationProperties(prefix = "university.mailers")
@Validated
public class MailerConfigurationProperties {
    private GmailMailConfig gmailMailConfig = new GmailMailConfig();

    @Data
    public static class GmailMailConfig {
        @NotBlank
        private String serviceUrl;

        @NotNull
        private Integer port;

        private String secureTransportPort;

        @NotNull
        private Boolean enableSMTP;
    }
}
