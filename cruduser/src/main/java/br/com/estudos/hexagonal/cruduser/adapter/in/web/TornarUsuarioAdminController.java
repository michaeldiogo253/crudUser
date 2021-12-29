package br.com.estudos.hexagonal.cruduser.adapter.in.web;

import br.com.estudos.hexagonal.cruduser.adapter.in.web.response.UserResponse;
import br.com.estudos.hexagonal.cruduser.application.service.TornarUsuarioAdminUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud-api")
public class TornarUsuarioAdminController {

    private final TornarUsuarioAdminUseCase tornarUsuarioAdminUseCase;

    @Transactional
    @PutMapping("/become-user-admin/{userId}")
    public ResponseEntity<UserResponse> execute(@PathVariable Long userId){

        TornarUsuarioAdminUseCase.OutputValues output =
                tornarUsuarioAdminUseCase.execute(new TornarUsuarioAdminUseCase.InputValues(userId));
        return ResponseEntity.ok().body(UserResponse.of(output.getUser()));
    }

}
