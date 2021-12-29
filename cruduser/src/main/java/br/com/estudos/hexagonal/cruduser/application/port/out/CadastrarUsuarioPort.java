package br.com.estudos.hexagonal.cruduser.application.port.out;

import br.com.estudos.hexagonal.cruduser.domain.User;

public interface CadastrarUsuarioPort {
    void cadastrarUsuario(User user);
}
