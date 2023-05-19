package br.com.vivo.desafio.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class SkillsDTO {

    private SkillsEnum nome;
    @Min(0)
    @Max(10)
    private Integer pontuacao;

    //metodos
    public SkillsEnum getNome() {
        return nome;
    }

    public void setNome(SkillsEnum nome) {
        this.nome = nome;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
}
