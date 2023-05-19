package br.com.vivo.desafio.api.controller;

import br.com.vivo.desafio.api.dto.DadosCandidatos;
import br.com.vivo.desafio.api.service.SendEmailService;
import br.com.vivo.desafio.api.service.SendSkillsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//anotação usada para api rest
//Para que o Spring reconheça a classe como um Controller
@RequestMapping("candidatos")
//qual é o url que o controller vai responder, quando chegar uma requisição
public class CandidatoController {

    private final SendEmailService sendEmailService;
    private final SendSkillsService sendSkillsService;
    public CandidatoController(SendEmailService emailSenderService, SendSkillsService sendSkillsService){
        this.sendEmailService = emailSenderService;
        this.sendSkillsService = sendSkillsService;
    }
    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody DadosCandidatos candidato) {
        this.sendEmailService.sendEmail(candidato.getEmail(), "Titulo", sendSkillsService.TesteCandidato(candidato));
        return ResponseEntity.ok("Success");
    }


    @PostMapping
    //chamando requisição Post no insomnia

    public DadosCandidatos cadastrar(@RequestBody @Valid DadosCandidatos dados) {
        System.out.println(dados);
        return dados;
    }
}
