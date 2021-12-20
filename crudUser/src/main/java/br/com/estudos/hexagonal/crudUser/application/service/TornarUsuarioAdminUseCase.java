package br.com.estudos.hexagonal.crudUser.application.service;

import br.com.estudos.hexagonal.crudUser.application.port.out.FindUserByIdPort;
import br.com.estudos.hexagonal.crudUser.domain.User;
import br.com.estudos.hexagonal.crudUser.util.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TornarUsuarioAdminUseCase extends UseCase<TornarUsuarioAdminUseCase.InputValues, TornarUsuarioAdminUseCase.OutputValues> {

    private final FindUserByIdPort findUserByIdPort;

    @Override
    public OutputValues execute(InputValues input) {
        User userBuscado = findUserByIdPort.findUserById(input.getIdUser());
        if (!userBuscado.isAdmin()) {
            userBuscado.becomeAdmin();
        }
        return OutputValues.of(userBuscado);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long idUser;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        User user;

        public static TornarUsuarioAdminUseCase.OutputValues of(User user) {
            return new TornarUsuarioAdminUseCase.OutputValues(user);
        }
    }
}
