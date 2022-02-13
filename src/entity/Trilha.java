package entity;

import enums.NotasEnum;
import enums.PerfilDeAcessoEnum;
import exception.PermissaoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    private String ano = String.valueOf(LocalDate.now().getYear());
    private List<Modulo> modulos = new ArrayList<>();

    public Trilha(EmpresaCliente empresaCliente, String ocupacao, Usuario usuario) throws PermissaoException {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.ADMINISTRADOR)) {
            throw new PermissaoException("Usuário não tem permissão para criar trilha");
        }
        this.empresaCliente = empresaCliente;
        this.ocupacao = ocupacao;
        this.numeroSequencialTrilha = this.getProximoNumeroSequencialTrilhaByOcupacao(this.ocupacao);
        this.nomeTrilha = this.formataNomeTrilha();
        this.apelidoTrilha = this.formataApelidoTrilha();
        this.empresaCliente.addTrilha(this);
    }

    public Trilha(Long id) {
        this.id = id;
    }

    private String formataApelidoTrilha() {
        return this.ocupacao + " " + this.numeroSequencialTrilha;
    }

    private String formataNomeTrilha() {
        return this.ocupacao + " " + this.empresaCliente.getNomeEmpresa() + " " + this.numeroSequencialTrilha + " " + this.ano;
    }

    private int getProximoNumeroSequencialTrilhaByOcupacao(String ocupacao) {
        //TODO Para ser feito precisa de conexão ao banco de dados
        return 0;
    }

    public void setAnotacoes(String anotacoes, Usuario usuario) throws PermissaoException {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.OPERACIONAL)) {
            throw new PermissaoException("Usuário não tem permissão para alterar anotações");
        }
        this.anotacoes = anotacoes;
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

    public void setNotaSatisfacaoGeral(NotasEnum notaSatisfacaoGeral, Usuario usuario) throws PermissaoException {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.OPERACIONAL)) {
            throw new PermissaoException("Usuário não tem permissão para alterar satisfação");
        }
        this.notaSatisfacaoGeral = notaSatisfacaoGeral;
    }

    public void addModulo(Modulo modulo) {
        this.modulos.add(modulo);
    }
}
