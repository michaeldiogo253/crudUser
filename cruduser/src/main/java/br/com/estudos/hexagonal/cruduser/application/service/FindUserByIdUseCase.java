package br.com.estudos.hexagonal.cruduser.application.service;

import br.com.estudos.hexagonal.cruduser.application.port.out.FindUserByIdPort;
import br.com.estudos.hexagonal.cruduser.domain.User;
import br.com.estudos.hexagonal.cruduser.util.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByIdUseCase extends UseCase<FindUserByIdUseCase.InputValues,
        FindUserByIdUseCase.OutputValues> {

        private final FindUserByIdPort findUserByIdPort;

    @Override
    public OutputValues execute(InputValues input) {
        User user = findUserByIdPort.findUserById(input.getIdUser());

        return OutputValues.of(user);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
      Long idUser;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        User user;
        public static OutputValues of(User user){
            return new OutputValues(user);
        }

    }


}