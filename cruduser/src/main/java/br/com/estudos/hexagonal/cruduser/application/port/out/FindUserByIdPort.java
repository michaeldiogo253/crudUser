package br.com.estudos.hexagonal.cruduser.application.port.out;

import br.com.estudos.hexagonal.cruduser.domain.User;

public interface FindUserByIdPort {
    User findUserById(Long id);
}
