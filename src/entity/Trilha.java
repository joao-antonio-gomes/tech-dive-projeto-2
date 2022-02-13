package entity;

import enums.NotasEnum;
import enums.PerfilDeAcessoEnum;
import exception.PermissaoException;

import java.time.LocalDate;
import java.util.Objects;

public class Trilha {
    private Long id;
    private int numeroSequencialTrilha;
    private String nomeTrilha;
    private String apelidoTrilha;
    private EmpresaCliente empresaCliente;
    private String ocupacao;
    private NotasEnum notaSatisfacaoGeral;
    private String anotacoes;

    public Trilha(EmpresaCliente empresaCliente, String ocupacao) {
        this.empresaCliente = empresaCliente;
        this.ocupacao = ocupacao;
        this.numeroSequencialTrilha = this.getProximoNumeroSequencialTrilhaByOcupacao(this.ocupacao);
        this.nomeTrilha = this.formataNomeTrilha();
        this.apelidoTrilha = this.formataApelidoTrilha();
    }

    public Trilha(Long id) {
        this.id = id;
    }

    private String formataApelidoTrilha() {
        return this.ocupacao + " " + this.numeroSequencialTrilha;
    }

    private String formataNomeTrilha() {
        String ano = String.valueOf(LocalDate.now().getYear());
        return this.ocupacao + " " + this.empresaCliente.getNomeEmpresa() + " " + this.numeroSequencialTrilha + " " + ano;
    }

    private int getProximoNumeroSequencialTrilhaByOcupacao(String ocupacao) {
        //TODO Para ser feito precisa de conexão ao banco de dados
        return 0;
    }

    public void setAnotacoes(String anotacoes, Usuario usuario) throws PermissaoException {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.OPERACIONAL)) {
            throw new PermissaoException("Usuário não tem permissão para alterar anotações");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trilha)) return false;
        Trilha trilha = (Trilha) o;
        return Objects.equals(id, trilha.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
