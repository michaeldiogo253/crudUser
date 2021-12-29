package br.com.estudos.hexagonal.cruduser.application.service;

import br.com.estudos.hexagonal.cruduser.application.port.out.DeletarUserByIdPort;
import br.com.estudos.hexagonal.cruduser.application.port.out.FindUserByIdPort;
import br.com.estudos.hexagonal.cruduser.util.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletarUsuarioByIdUseCase extends UseCase<DeletarUsuarioByIdUseCase.InputValues,
        DeletarUsuarioByIdUseCase.OutputValues> {

    private final DeletarUserByIdPort deletarUserByIdPort;
    private final FindUserByIdPort findUserByIdPort;

    @Override
    public OutputValues execute(InputValues input) {
        findUserByIdPort.findUserById(input.getId());

        deletarUserByIdPort.deletarUserById(input.id);

        return OutputValues.ofEmpty();
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long id;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        private OutputValues() {
        }

        private static OutputValues ofEmpty() {
            return new OutputValues();
        }

    }
}