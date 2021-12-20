package br.com.estudos.hexagonal.crudUser.adapter.in.web;

import br.com.estudos.hexagonal.crudUser.adapter.in.web.response.UserResponse;
import br.com.estudos.hexagonal.crudUser.application.service.FindUserByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud-api")
public class FindUserByIdController {

    private final FindUserByIdUseCase findUserByIdUseCase;

    @GetMapping("/find-user/{idUser}")
    public ResponseEntity<UserResponse> executa(@PathVariable Long idUser) {
        FindUserByIdUseCase.OutputValues output = findUserByIdUseCase.execute(new FindUserByIdUseCase.InputValues(idUser));

        UserResponse response = new UserResponse(output.getUser());
        return ResponseEntity.ok().body(response);
    }

}
