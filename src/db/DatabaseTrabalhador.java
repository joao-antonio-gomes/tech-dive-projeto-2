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

    public static Trabalhador getTrabalhadorById(int id){
        for(Trabalhador trabalhador : trabalhadores){
            if(trabalhador.getId() == id){
                return trabalhador;
            }
        }
        return null;
    }

    public static List<Trabalhador> getTrabalhadoresByEmpresaId(int id) {
        List<Trabalhador> trabalhadoresByEmpresaId = new ArrayList<>();
        for(Trabalhador trabalhador : trabalhadores) {
            if(trabalhador.getEmpresaId() == id) {
                trabalhadoresByEmpresaId.add(trabalhador);
            }
        }
        return trabalhadoresByEmpresaId;
    }

    public static List<Trabalhador> getTrabalhadoresByTrilhaId(int id) {
        List<Trabalhador> trabalhadoresByTrilhaId = new ArrayList<>();
        for(Trabalhador trabalhador : trabalhadores) {
            if(trabalhador.getTrilhasId().contains(id)) {
                trabalhadoresByTrilhaId.add(trabalhador);
            }
        }
        return trabalhadoresByTrilhaId;
    }
}
