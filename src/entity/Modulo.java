package entity;

import enums.PerfilDeAcessoEnum;
import enums.StatusModuloEnum;
import exception.PermissaoException;

import java.time.OffsetDateTime;

public class Modulo {
    private Long id;
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
                  String tarefaValidacao, Usuario usuario) throws PermissaoException {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.ADMINISTRADOR)) {
            throw new PermissaoException("Usuário não tem permissão para criar módulos");
        }
        this.trilha = trilha;
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
    }

    public void alterarStatusModulo(StatusModuloEnum statusModulo, Usuario usuario) throws PermissaoException {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.ADMINISTRADOR)) {
            throw new PermissaoException("Usuário não tem permissão para alterar anotações");
        }

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

    public Trilha getTrilha() {
        return trilha;
    }

    public boolean isPossivelAvaliar() {
        return this.statusModulo == StatusModuloEnum.EM_FASE_DE_AVALIACAO && this.dataFinalizacao.isAfter(OffsetDateTime.now());
    }
}
