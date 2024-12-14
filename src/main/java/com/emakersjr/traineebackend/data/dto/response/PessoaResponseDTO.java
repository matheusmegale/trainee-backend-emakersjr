package com.emakersjr.traineebackend.data.dto.response;

import com.emakersjr.traineebackend.data.entity.Livro;
import com.emakersjr.traineebackend.data.entity.Pessoa;

import java.util.List;

public record PessoaResponseDTO(

        Long id_pessoa,

        String nome,

        String cep,

        String email,

        String senha,

        List<Livro> livros
) {
    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getId_pessoa(), pessoa.getNome(), pessoa.getCep(), pessoa.getEmail(), pessoa.getSenha(), pessoa.getLivros());
    }
}
