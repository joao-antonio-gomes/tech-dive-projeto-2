package db;

import entity.Trabalhador;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTrabalhador {
    private static List<Trabalhador> trabalhadores = new ArrayList<>();

    public static List<Trabalhador> getTrabalhadores(){
        return trabalhadores;
    }

    public static void addTrabalhador(Trabalhador trabalhador){
        trabalhadores.add(trabalhador);
    }
}
