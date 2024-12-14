package com.emakersjr.traineebackend.data.dto.request;

import com.emakersjr.traineebackend.data.entity.Livro;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PessoaRequestDTO(

        @NotBlank(message = "Nome eh necessario")
        String nome,

        String cep,

        @NotBlank(message = "Email eh necessario")
        String email,

        @NotBlank(message = "Senha eh necessaria")
        String senha,

        List<Livro> livros
) {
}
