package br.com.estudos.hexagonal.crudUser.application.port.out;

import br.com.estudos.hexagonal.crudUser.domain.User;

public interface FindUserByIdPort {
    User findUserById(Long id);
}
