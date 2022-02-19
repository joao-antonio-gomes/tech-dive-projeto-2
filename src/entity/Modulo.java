package entity;

import db.DatabaseModulo;
import enums.StatusModuloEnum;

import java.time.OffsetDateTime;
import java.util.List;

public class Modulo {
    private static int numeroModulos = 0;
    private int id;
    private Trilha trilha;
    private int numeroSequencialModulo;
    private String nome;
    private StatusModuloEnum statusModulo;
    private int prazoLimiteAvaliacaoDiasUteis;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFinalizacao;
    private String habilidadesTrabalhadas;
    private String tarefaValidacao;

    public Modulo(Trilha trilha, String nome, StatusModuloEnum statusModulo, int prazoLimiteDiasUteis, String habilidadesTrabalhadas,
                  String tarefaValidacao) {
        this.id = ++numeroModulos;
        this.trilha = trilha;
        this.numeroSequencialModulo = getProximoNumeroSequencialModuloByTrilha();
        this.nome = nome;
        this.statusModulo = statusModulo;
        this.prazoLimiteAvaliacaoDiasUteis = getNumeroDiasCorridosPrazoAvaliacaoByDiasUteis(prazoLimiteDiasUteis);
        if (statusModulo == StatusModuloEnum.CURSO_EM_ANDAMENTO) {
            this.dataInicio = OffsetDateTime.now();
        }
        this.habilidadesTrabalhadas = habilidadesTrabalhadas;
        this.tarefaValidacao = tarefaValidacao;
        DatabaseModulo.addModulo(this);
    }

    private int getNumeroDiasCorridosPrazoAvaliacaoByDiasUteis(int prazoLimiteDiasUteis) {
        if (prazoLimiteDiasUteis <= 0) {
            prazoLimiteDiasUteis = 10;
        }
        int diasCorridos = 0;
        OffsetDateTime dataHoje = OffsetDateTime.now();
        while (prazoLimiteDiasUteis > 0) {
            if (dataHoje.getDayOfWeek().getValue() < 6) {
                prazoLimiteDiasUteis--;
            }
            dataHoje = dataHoje.plusDays(1);
            diasCorridos++;
        }
        return diasCorridos;
    }

    public void alterarStatusModulo(StatusModuloEnum statusModulo) {
        switch (statusModulo) {
            case CURSO_EM_ANDAMENTO:
                this.dataInicio = OffsetDateTime.now();
                break;
            case EM_FASE_DE_AVALIACAO:
                OffsetDateTime dataHoje = OffsetDateTime.now();
                int diasCorridos = getNumeroDiasCorridosPrazoAvaliacaoByDiasUteis(this.prazoLimiteAvaliacaoDiasUteis);
                this.dataFinalizacao = dataHoje.plusDays(diasCorridos);
                break;
            case FASE_DE_AVALIACAO_CONCLUIDA:
                this.dataFinalizacao = OffsetDateTime.now();
                break;
        }
    }

    private int getProximoNumeroSequencialModuloByTrilha() {
        List<Modulo> modulosByIdTrilha = DatabaseModulo.getModulosByIdTrilha(this.trilha.getId());
        if (modulosByIdTrilha.isEmpty()) {
            return 1;
        }
        return modulosByIdTrilha.stream().map(Modulo::getNumeroSequencialModulo).max(Integer::compareTo).get() + 1;
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

    public int getTrilhaId() {
        return trilha.getId();
    }

    public int getTrilhaEmpresaId() {
        return trilha.getEmpresaId();
    }

    public int getId() {
        return id;
    }
}
