package br.com.estudos.hexagonal.cruduser.adapter.in.web;

import br.com.estudos.hexagonal.cruduser.adapter.in.web.request.AlterarUsuarioRequest;
import br.com.estudos.hexagonal.cruduser.adapter.in.web.response.UserResponse;
import br.com.estudos.hexagonal.cruduser.application.service.AlterarUsuarioUseCase;
import br.com.estudos.hexagonal.cruduser.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud-api")
public class AlterarUsuarioController {

    private final AlterarUsuarioUseCase useCase;

    @Transactional
    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserResponse> execute(@PathVariable Long id, @RequestBody AlterarUsuarioRequest request) {
        AlterarUsuarioUseCase.OutputValues output = useCase.execute(new AlterarUsuarioUseCase.InputValues(id, request));
        User userAlterado = output.getUser();

        return ResponseEntity.ok().body(UserResponse.of(userAlterado));
    }
}
