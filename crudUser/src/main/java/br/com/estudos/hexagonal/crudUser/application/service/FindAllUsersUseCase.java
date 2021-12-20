package br.com.estudos.hexagonal.crudUser.application.service;

import br.com.estudos.hexagonal.crudUser.application.port.out.FindAllUsersPort;
import br.com.estudos.hexagonal.crudUser.domain.User;
import br.com.estudos.hexagonal.crudUser.util.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllUsersUseCase extends UseCase<FindAllUsersUseCase.InputValues,
        FindAllUsersUseCase.OutputValues> {

    private final FindAllUsersPort findAllUsersPort;

    @Override
    public OutputValues execute(InputValues input) {

        List<User> listaUsuarios = findAllUsersPort.findAllUsers();
        return OutputValues.of(listaUsuarios);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {

    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<User> listaUsuarios;

        public static OutputValues of(List<User> listaUsuarios) {
            return new OutputValues(listaUsuarios);
        }
    }

}