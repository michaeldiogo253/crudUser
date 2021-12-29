package br.com.estudos.hexagonal.cruduser.adapter.out.persistense;

import br.com.estudos.hexagonal.cruduser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {

}
