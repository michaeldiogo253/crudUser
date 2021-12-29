package br.com.estudos.hexagonal.cruduser.application.port.out;

import br.com.estudos.hexagonal.cruduser.domain.User;

import java.util.List;

public interface FindAllUsersPort {
    List<User> findAllUsers();
}
