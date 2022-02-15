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
}
