package br.com.estudos.hexagonal.cruduser.adapter.out.persistense;

import br.com.estudos.hexagonal.cruduser.application.port.out.CadastrarUsuarioPort;
import br.com.estudos.hexagonal.cruduser.application.port.out.DeletarUserByIdPort;
import br.com.estudos.hexagonal.cruduser.application.port.out.FindAllUsersPort;
import br.com.estudos.hexagonal.cruduser.application.port.out.FindUserByIdPort;
import br.com.estudos.hexagonal.cruduser.domain.User;
import br.com.estudos.hexagonal.cruduser.util.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioAdapter implements
        CadastrarUsuarioPort,
        FindUserByIdPort,
        FindAllUsersPort,
        DeletarUserByIdPort {

    private final UsuarioRepository userRepository;

    @Override
    public void cadastrarUsuario(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deletarUserById(Long id) {
        userRepository.deleteById(id);
    }
}
