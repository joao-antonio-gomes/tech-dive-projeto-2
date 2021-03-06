package db;

import entity.Trilha;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTrilha {
    private static List<Trilha> trilhas = new ArrayList<>();

    public static List<Trilha> getTrilhas(){
        return trilhas;
    }

    public static void addTrilha(Trilha trilha){
        trilhas.add(trilha);
    }

    public static List<Trilha> getTrilhasByEmpresaId(int idEmpresa) {
        List<Trilha> trilhas = new ArrayList<>();
        for(Trilha trilha : trilhas){
            if(trilha.getEmpresaId() == idEmpresa){
                trilhas.add(trilha);
            }
        }
        return trilhas;
    }
}
