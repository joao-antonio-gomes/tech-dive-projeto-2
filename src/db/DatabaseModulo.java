package db;

import entity.Modulo;

import java.util.ArrayList;
import java.util.List;

public class DatabaseModulo {
    private static List<Modulo> modulos = new ArrayList<>();

    public static List<Modulo> getModulos(){
        return modulos;
    }

    public static void addModulo(Modulo modulo){
        modulos.add(modulo);
    }

    public static List<Modulo> getModulosByIdTrilha(int idTrilha){
        List<Modulo> modulosByIdTrilha = new ArrayList<>();
        for (Modulo modulo : modulos) {
            if (modulo.getTrilhaId() == idTrilha) {
                modulosByIdTrilha.add(modulo);
            }
        }
        return modulosByIdTrilha;
    }

    public static List<Modulo> getModulosByIdEmpresa(int idEmpresa) {
        List<Modulo> modulosByIdEmpresa = new ArrayList<>();
        for (Modulo modulo : modulos) {
            if (modulo.getTrilhaEmpresaId() == idEmpresa) {
                modulosByIdEmpresa.add(modulo);
            }
        }
        return modulosByIdEmpresa;
    }
}
