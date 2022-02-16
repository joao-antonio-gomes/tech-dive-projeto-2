package entity;

import db.DatabaseAvaliacao;
import enums.NotasEnum;
import exception.AvaliacaoException;

public class Avaliacao {
    private static int numeroAvaliacoes = 0;
    private int id;
    private NotasEnum nota;
    private String anotacao;
    private boolean isTarefaRealizada;
    private Modulo modulo;
    private Trabalhador trabalhador;

    public Avaliacao(NotasEnum nota, String anotacao, boolean isTarefaRealizada, Modulo modulo, Trabalhador trabalhador) throws AvaliacaoException {
        if (!modulo.isPossivelAvaliar()) {
            throw new AvaliacaoException("Modulo não pode ser avaliado!");
        }
        this.nota = nota;
        this.anotacao = anotacao;
        this.isTarefaRealizada = isTarefaRealizada;
        this.modulo = modulo;
        this.trabalhador = trabalhador;
        DatabaseAvaliacao.addAvaliacao(this);
    }

    public int getTrabalhadorId() {
        return this.trabalhador.getId();
    }

    public int getModuloId() {
        return this.modulo.getId();
    }

    public int getTrilhaId() {
        return this.modulo.getTrilha().getId();
    }
}
