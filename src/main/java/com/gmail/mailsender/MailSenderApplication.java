package com.gmail.mailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderApplication {

    public static void main(String[] args) {

        SpringApplication.run(MailSenderApplication.class, args);
    }

    private final EmailSenderService service;

    public MailSenderApplication(EmailSenderService service) {
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        service.sendMail("toMailUsername", "Test", "This is a test message");
    }

}
