package br.com.estudos.hexagonal.cruduser.adapter.in.web;

import br.com.estudos.hexagonal.cruduser.adapter.in.web.response.UserResponse;
import br.com.estudos.hexagonal.cruduser.application.service.FindAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/crud-api")
public class FindAllUsersController {
    private final FindAllUsersUseCase findAllUsersUseCase;

    @GetMapping("/listar-todos-os-usuarios")
    public ResponseEntity<List<UserResponse>> execute() {
        FindAllUsersUseCase.OutputValues output = findAllUsersUseCase.execute(new FindAllUsersUseCase.InputValues());

        return ResponseEntity.ok().body(UserResponse.of(output.getListaUsuarios()));
    }
}
