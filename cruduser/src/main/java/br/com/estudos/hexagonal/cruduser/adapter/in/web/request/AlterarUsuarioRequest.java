package br.com.estudos.hexagonal.cruduser.adapter.in.web.request;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class AlterarUsuarioRequest {
    @NotNull(message = "nome não pode ser nulo")
    String nome;

    @NotNull(message = "cpf não pode ser nulo")
    String cpf;

    @NotNull(message = "telefone não pode ser nulo")
    String telefone;
}
