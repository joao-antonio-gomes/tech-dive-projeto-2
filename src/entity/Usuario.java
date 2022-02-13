package entity;

import enums.PerfilDeAcessoEnum;
import exception.DocumentoException;
import utils.Validadores;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private List<PerfilDeAcessoEnum> perfilDeAcesso = new ArrayList<>();

    public Usuario(String nome, String cpf, String email, String senha, ArrayList<PerfilDeAcessoEnum> perfilDeAcesso) throws DocumentoException {
        this.nome = nome;
        this.cpf = Validadores.validaCpf(cpf);
        this.email = Validadores.validaEmail(email);
        this.senha = Validadores.validaSenha(senha);
        this.perfilDeAcesso = perfilDeAcesso;
    }

    public boolean isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum perfilDeAcesso) {
        boolean bool = false;

        for (PerfilDeAcessoEnum perfil : this.perfilDeAcesso) {
            if (perfil.getCodigo() >= perfilDeAcesso.getCodigo()) {
                bool = true;
                break;
            }
        }

        return bool;
    }
}
