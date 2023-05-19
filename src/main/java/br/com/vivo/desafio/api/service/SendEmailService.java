package br.com.vivo.desafio.api.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendEmailService {
    private final JavaMailSender javaMailSender;
    private final Logger logger = LoggerFactory.getLogger(SendEmailService.class);

    public SendEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String title, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        try {
            logger.info("Enviando email...");
            var message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(title);
            message.setText(content);
            javaMailSender.send(message);
            logger.info("Email enviado com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao enviar email", e);
        }
    }
}



