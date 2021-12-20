package br.com.estudos.hexagonal.crudUser.application.port.out;

import br.com.estudos.hexagonal.crudUser.domain.User;

import java.util.List;

public interface FindAllUsersPort {
    List<User> findAllUsers();
}
