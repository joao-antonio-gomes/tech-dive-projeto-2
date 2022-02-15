package db;

import entity.Usuario;

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
}
