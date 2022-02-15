package db;

import entity.Avaliacao;
import entity.Trabalhador;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAvaliacao {
    private static List<Avaliacao> avaliacoes = new ArrayList<>();

    public static List<Avaliacao> getAvaliacoes(){
        return avaliacoes;
    }

    public static void addAvaliacao(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }
}
