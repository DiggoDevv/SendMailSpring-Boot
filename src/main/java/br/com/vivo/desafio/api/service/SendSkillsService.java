package br.com.vivo.desafio.api.service;

import br.com.vivo.desafio.api.dto.DadosCandidatos;
import br.com.vivo.desafio.api.dto.SkillsDTO;
import br.com.vivo.desafio.api.dto.SkillsEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendSkillsService {
    public String TesteCandidato(DadosCandidatos candidate) {

        int backend = 0;
        int frontend = 0;
        boolean fullstack = true;

        List<SkillsDTO> skills = candidate.getHabilidade();
        for (SkillsDTO skill : skills) {
            SkillsEnum nome = skill.getNome();
            int pontuacao = skill.getPontuacao();

            switch (nome) {
                case JAVA, CSHARP, GOLANG -> backend += pontuacao > 7 ? 1 : 0;
                case VUE, JAVASCRIPT, PHP -> frontend += pontuacao > 7 ? 1 : 0;
            }
            if (pontuacao < 7 || pontuacao > 10) {
                fullstack = false;
            }
        }
        StringBuilder resultado = new StringBuilder();
        if (fullstack) {
            resultado.append("Parabéns, você foi classificado como desenvolvedor Backend e Frontend.");
        } else if (backend == 3) {
            resultado.append("Parabéns, você foi classificado como desenvolvedor back-end.");
        } else if (frontend == 3) {
            resultado.append("Parabéns, você foi classificado como desenvolvedor front-end.");
        } else {
            resultado.append("Desculpe, você não atendeu aos requisitos para as vagas disponíveis.");
        }

        return resultado.toString();
    }
}