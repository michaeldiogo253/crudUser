package br.com.estudos.hexagonal.cruduser.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser = TypeUser.COMMOM;

    public User(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public boolean isAdmin() {
        return typeUser.toString().equals("ADMIN");
    }

    public void becomeAdmin(){
        if(!isAdmin()){
            this.typeUser = TypeUser.ADMIN;
        }
    }
}
