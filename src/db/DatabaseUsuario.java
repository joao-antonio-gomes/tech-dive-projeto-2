package db;

import entity.Usuario;
import enums.PerfilDeAcessoEnum;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUsuario {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static List<Usuario> getUsuarios(){
        return usuarios;
    }

    public static void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public static List<Usuario> getUsuariosByPerfilDeAcesso(PerfilDeAcessoEnum perfilDeAcessoEnum) {
        List<Usuario> usuariosByPerfilDeAcesso = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.isUsuarioComPerfilDeAcesso(perfilDeAcessoEnum)) {
                usuariosByPerfilDeAcesso.add(usuario);
            }
        }
        return usuariosByPerfilDeAcesso;
    }
}
