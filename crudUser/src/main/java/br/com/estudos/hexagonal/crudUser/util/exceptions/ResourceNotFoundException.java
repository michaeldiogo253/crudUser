package br.com.estudos.hexagonal.crudUser.util.exceptions;


public class ResourceNotFoundException extends RuntimeException  {
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
