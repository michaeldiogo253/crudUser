package br.com.estudos.hexagonal.crudUser.application.service;

import br.com.estudos.hexagonal.crudUser.application.port.out.CadastrarUsuarioPort;
import br.com.estudos.hexagonal.crudUser.domain.User;
import br.com.estudos.hexagonal.crudUser.util.UseCase;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CadastrarUsuarioUseCase extends
        UseCase<CadastrarUsuarioUseCase.InputValues,
                CadastrarUsuarioUseCase.OutputValues> {

    private final CadastrarUsuarioPort cadastrarUsuarioPort;

    @Override
    public OutputValues execute(InputValues input) {
        User user = new User(input.getNome(), input.getCpf(), input.getTelefone());
        cadastrarUsuarioPort.cadastrarUsuario(user);
        return OutPutValues.ofEmpty();
    }

    @Value
    @AllArgsConstructor(staticName = "of")
    public static class InputValues implements UseCase.InputValues {
        String nome;
        String cpf;
        String telefone;
    }

    @Value
    @AllArgsConstructor(staticName = "ofEmpty")
    public static class OutPutValues implements UseCase.OutputValues {
    }
}
