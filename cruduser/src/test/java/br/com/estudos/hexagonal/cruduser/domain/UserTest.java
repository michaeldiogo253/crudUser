package br.com.estudos.hexagonal.cruduser.domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    User user1 = new User("Michael", "1147594633", "37341310");
    User user2 = new User("Joao", "2365974111", "997310625");
    User user3 = new User("Maria", "999877555333", "998751310");
    List<User> usuarios = List.of(user1, user2, user3);

    @Test
    void deveriaChecharDadosDoUsuario() {
        assertThat(user1.getNome()).startsWith("Mich");
        assertThat(user1.getCpf()).contains("33");
        assertThat(user1).isNotNull();
    }

    @Test
    void verificaSeTodosOsUsuariosPossuemLetraANoNome(){
        assertThat(usuarios).allMatch(usuario -> usuario.getNome().contains("a"));
    }
    @Test
    void verificaSeAlgumUsuarioSeChamaMaria(){
        assertThat(usuarios).anyMatch(usuario -> usuario.getNome().contains("Maria"));
    }
    @Test
    void verificaElementosDaLista(){
        assertThat(usuarios).first().isEqualTo(user1);
        assertThat(usuarios).element(1).isEqualTo(user2);
        assertThat(usuarios).last().isEqualTo(user3);
        assertThat(usuarios.size()).isEqualTo(3);
    }
}