package br.com.estudos.hexagonal.cruduser.adapter.in.web;

import br.com.estudos.hexagonal.cruduser.adapter.in.web.request.CadastrarUsuarioRequest;
import br.com.estudos.hexagonal.cruduser.application.service.CadastrarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud-api")
public class CadastrarUsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    @PostMapping("/register-user")
    public ResponseEntity<?> cadastrarUsuario(
            @RequestBody @Valid CadastrarUsuarioRequest request) {
        cadastrarUsuarioUseCase.execute(CadastrarUsuarioUseCase.InputValues.of(
                request.getNome(),
                request.getCpf(),
                request.getTelefone()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
