package com.emakersjr.traineebackend.data.entity;

import com.emakersjr.traineebackend.data.dto.request.LivroRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name="livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_livro")
    private Long id_livro;

    @Column(name="nome", nullable = false, length = 45)
    private String nome;

    @Column(name="autor", nullable = false, length = 45)
    private String autor;

    @Column(name="data_lancamento", nullable = false, length = 20)
    private String data_lancamento;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "emprestimo",
            joinColumns = @JoinColumn(name = "id_livro"),
            inverseJoinColumns = @JoinColumn(name = "id_pessoa")
    )
    private List<Pessoa> pessoas;

    // metodo para adicionar uma pessoa à lista
    public void addPessoa(Pessoa pessoa) {
        if (pessoas == null) {
            pessoas = new ArrayList<>();
        }
        pessoas.add(pessoa);
    }

    @Builder
    public Livro(LivroRequestDTO livroRequestDTO) {
        this.nome = livroRequestDTO.nome();
        this.autor = livroRequestDTO.autor();
        this.data_lancamento = livroRequestDTO.data_lancamento();
        this.pessoas = livroRequestDTO.pessoas();
    }

//    public Long getId_livro() {
//        return id_livro;
//    }
//
//    public void setId_livro(Long id_livro) {
//        this.id_livro = id_livro;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getAutor() {
//        return autor;
//    }
//
//    public void setAutor(String autor) {
//        this.autor = autor;
//    }
//
//    public String getData_lancamento() {
//        return data_lancamento;
//    }
//
//    public void setData_lancamento(String data_lancamento) {
//        this.data_lancamento = data_lancamento;
//    }
//
//    public List<Pessoa> getPessoas() {
//        return pessoas;
//    }
//
//    public void setPessoas(List<Pessoa> pessoas) {
//        this.pessoas = pessoas;
//    }
}
