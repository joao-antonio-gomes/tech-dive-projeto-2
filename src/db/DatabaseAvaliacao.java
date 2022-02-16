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

    public static List<Avaliacao> getAvaliacoesByTrabalhadorId(int id) {
        List<Avaliacao> avaliacoesByTrabalhadorId = new ArrayList<>();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getTrabalhadorId() == id) {
                avaliacoesByTrabalhadorId.add(avaliacao);
            }
        }
        return avaliacoesByTrabalhadorId;
    }

    public static List<Avaliacao> getAvaliacoesByModuloId(int id) {
        List<Avaliacao> avaliacoesByModuloId = new ArrayList<>();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getModuloId() == id) {
                avaliacoesByModuloId.add(avaliacao);
            }
        }
        return avaliacoesByModuloId;
    }

    public static List<Avaliacao> getAvaliacoesByTrilhaId(int id) {
        List<Avaliacao> avaliacoesByModuloId = new ArrayList<>();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getTrilhaId() == id) {
                avaliacoesByModuloId.add(avaliacao);
            }
        }
        return avaliacoesByModuloId;
    }
}
