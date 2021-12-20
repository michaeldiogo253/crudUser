package br.com.estudos.hexagonal.crudUser.adapter.out.persistense;

import br.com.estudos.hexagonal.crudUser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {

}
