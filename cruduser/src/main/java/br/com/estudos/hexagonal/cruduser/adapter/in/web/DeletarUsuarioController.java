package br.com.estudos.hexagonal.cruduser.adapter.in.web;

import br.com.estudos.hexagonal.cruduser.application.service.DeletarUsuarioByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud-api")
public class DeletarUsuarioController {

    private final DeletarUsuarioByIdUseCase useCase;

    @Transactional
    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<Void> execute(@PathVariable Long id){
       useCase.execute(new DeletarUsuarioByIdUseCase.InputValues(id));
       return ResponseEntity.noContent().build();
    }

}
