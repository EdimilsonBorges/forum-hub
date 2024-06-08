package com.edimilsonborges.forum_hub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "topicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String titulo;
    @Column(unique = true, nullable = false)
    private String mensagem;
    private LocalDateTime dataCriacao;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonIgnore
    @ManyToOne
    private Usuario usuario;
    @JsonIgnore
    @ManyToOne
    private Curso curso;

    public void atualizarInformacoes(DadosAtualizacaoTopico dadosAtualizacaoTopico) {

        Optional<String> optionalTitulo = Optional.ofNullable(dadosAtualizacaoTopico.titulo());
        optionalTitulo.ifPresent(t -> this.titulo = t);

        Optional<String> optionalMensagem = Optional.ofNullable(dadosAtualizacaoTopico.mensagem());
        optionalMensagem.ifPresent(m -> this.mensagem = m);

        Optional<String> optionalStatus = Optional.ofNullable(dadosAtualizacaoTopico.status());
        optionalStatus.ifPresent(s -> this.status = Status.valueOf(s));

    }
}