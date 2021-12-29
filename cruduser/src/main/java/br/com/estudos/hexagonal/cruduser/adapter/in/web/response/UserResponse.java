package br.com.estudos.hexagonal.cruduser.adapter.in.web.response;

import br.com.estudos.hexagonal.cruduser.domain.TypeUser;
import br.com.estudos.hexagonal.cruduser.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private TypeUser typeUser;

    public UserResponse(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.cpf = user.getCpf();
        this.telefone = user.getTelefone();
        this.typeUser = getTypeUser();
    }

    public static List<UserResponse> of (List<User> listaDeUsuario){
        return listaDeUsuario.stream()
                .map(UserResponse::of)
                .collect(Collectors.toList());
    }

    public static UserResponse of(User user){
        return new UserResponse(
                user.getId(),
                user.getNome(),
                user.getCpf(),
                user.getTelefone(),
                user.getTypeUser()
        );
    }

}
