package br.com.vivo.desafio.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class DadosCandidatos {

    @NotBlank
    private String nome;
    @Email
    private String email;

    @Valid
    @NotEmpty
    private List<SkillsDTO> habilidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SkillsDTO> getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(List<SkillsDTO> habilidade) {
        this.habilidade = habilidade;
    }
}
