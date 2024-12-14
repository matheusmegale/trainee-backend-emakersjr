package com.emakersjr.traineebackend.service;

import com.emakersjr.traineebackend.data.dto.request.PessoaRequestDTO;
import com.emakersjr.traineebackend.data.dto.response.LivroResponseDTO;
import com.emakersjr.traineebackend.data.dto.response.PessoaResponseDTO;
import com.emakersjr.traineebackend.data.entity.Livro;
import com.emakersjr.traineebackend.data.entity.Pessoa;
import com.emakersjr.traineebackend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaResponseDTO> getAllPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public PessoaResponseDTO getPessoaById(Long id_pessoa) {
        Pessoa pessoa = getPessoaEntityById(id_pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = new Pessoa(pessoaRequestDTO);
        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO updatePessoa(Long id_pessoa, PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = getPessoaEntityById(id_pessoa);
        pessoa.setNome(pessoaRequestDTO.nome());
        pessoa.setCep(pessoaRequestDTO.cep());
        pessoa.setEmail(pessoaRequestDTO.email());
        pessoa.setSenha(pessoaRequestDTO.senha());
        pessoa.setLivros(pessoaRequestDTO.livros());
        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    private Pessoa getPessoaEntityById(Long id_pessoa) {
        Pessoa pessoa = pessoaRepository.findById(id_pessoa).orElseThrow(()-> new RuntimeException("Pessoa nao encontrada"));
        return pessoa;
    }
}
