package br.com.estudos.hexagonal.cruduser.application.service;

import br.com.estudos.hexagonal.cruduser.adapter.in.web.request.AlterarUsuarioRequest;
import br.com.estudos.hexagonal.cruduser.application.port.out.FindUserByIdPort;
import br.com.estudos.hexagonal.cruduser.domain.User;
import br.com.estudos.hexagonal.cruduser.util.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlterarUsuarioUseCase extends UseCase<AlterarUsuarioUseCase.InputValues,
        AlterarUsuarioUseCase.OutputValues> {

    private final FindUserByIdPort findUserByIdPort;

    @Override
    public OutputValues execute(InputValues input) {
        User userASerAlterado = findUserByIdPort.findUserById(input.getId());
        userASerAlterado.setNome(input.request.getNome());
        userASerAlterado.setCpf(input.request.getCpf());
        userASerAlterado.setTelefone(input.request.getTelefone());

        return OutputValues.of(userASerAlterado);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long id;
        AlterarUsuarioRequest request;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        User user;

        public static AlterarUsuarioUseCase.OutputValues of(User user) {
            return new AlterarUsuarioUseCase.OutputValues(user);
        }
    }

}