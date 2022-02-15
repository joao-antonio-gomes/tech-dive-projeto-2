package entity;

import db.DatabaseModulo;
import db.DatabaseTrilha;
import enums.StatusModuloEnum;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Modulo {
    private static int numeroModulos = 0;
    private int id;
    private Trilha trilha;
    private int numeroSequencialModulo;
    private String nome;
    private StatusModuloEnum statusModulo;
    private int prazoLimiteAvaliacaoDias = 10;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFinalizacao;
    private String habilidadesTrabalhadas;
    private String tarefaValidacao;

    public Modulo(Trilha trilha, String nome, StatusModuloEnum statusModulo, int prazoLimiteDias, String habilidadesTrabalhadas,
                  String tarefaValidacao) {
        this.id = ++numeroModulos;
        this.trilha = trilha;
        this.numeroSequencialModulo = getProximoNumeroSequencialTrilhaByModulo();
        this.nome = nome;
        this.statusModulo = statusModulo;
        if (prazoLimiteDias > 0) {
            this.prazoLimiteAvaliacaoDias = prazoLimiteDias;
        }
        if (statusModulo == StatusModuloEnum.CURSO_EM_ANDAMENTO) {
            this.dataInicio = OffsetDateTime.now();
        }
        this.habilidadesTrabalhadas = habilidadesTrabalhadas;
        this.tarefaValidacao = tarefaValidacao;
        this.trilha.addModulo(this);
        DatabaseModulo.addModulo(this);
    }

    public void alterarStatusModulo(StatusModuloEnum statusModulo) {

        switch (statusModulo) {
            case CURSO_EM_ANDAMENTO:
                this.dataInicio = OffsetDateTime.now();
                break;
            case EM_FASE_DE_AVALIACAO:
                OffsetDateTime dataHoje = OffsetDateTime.now();
                this.dataFinalizacao = dataHoje.plusDays(this.prazoLimiteAvaliacaoDias);
                break;
            case FASE_DE_AVALIACAO_CONCLUIDA:
                this.dataFinalizacao = OffsetDateTime.now();
                break;
        }
    }

    private int getProximoNumeroSequencialTrilhaByModulo() {
        List<Trilha> trilhas = DatabaseTrilha.getTrilhas();
        trilhas = trilhas.stream()
                .filter(trilha -> trilha.equals(this.trilha)).collect(Collectors.toList());
        if (trilhas.size() > 0) {
            return trilhas.get(0).getModulos().size() + 1;
        }
        return 1;
    }

    private int getNumeroSequencialModulo() {
        return numeroSequencialModulo;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public boolean isPossivelAvaliar() {
        return this.statusModulo == StatusModuloEnum.EM_FASE_DE_AVALIACAO && this.dataFinalizacao.isAfter(OffsetDateTime.now());
    }
}
