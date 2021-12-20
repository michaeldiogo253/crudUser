package br.com.estudos.hexagonal.crudUser.adapter.out.persistense;

import br.com.estudos.hexagonal.crudUser.application.port.out.CadastrarUsuarioPort;
import br.com.estudos.hexagonal.crudUser.application.port.out.FindAllUsersPort;
import br.com.estudos.hexagonal.crudUser.application.port.out.FindUserByIdPort;
import br.com.estudos.hexagonal.crudUser.domain.User;
import br.com.estudos.hexagonal.crudUser.util.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioAdapter implements
        CadastrarUsuarioPort,
        FindUserByIdPort,
        FindAllUsersPort
{

    private final UsuarioRepository userRepository;

    @Override
    public void cadastrarUsuario(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
