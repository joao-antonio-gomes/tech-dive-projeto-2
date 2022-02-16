package entity;

import db.DatabaseTrilha;
import enums.NotasEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trilha {
    private static int numeroTrilhas = 0;
    private int id;
    private int numeroSequencialTrilha;
    private String nomeTrilha;
    private String apelidoTrilha;
    private EmpresaCliente empresaCliente;
    private String ocupacao;
    private NotasEnum notaSatisfacaoGeral;
    private String anotacoes;
    private String ano = String.valueOf(LocalDate.now().getYear());

    public Trilha(EmpresaCliente empresaCliente, String ocupacao) {
        this.id = ++numeroTrilhas;
        this.empresaCliente = empresaCliente;
        this.ocupacao = ocupacao;
        this.numeroSequencialTrilha = this.getProximoNumeroSequencialTrilhaByOcupacao(this.ocupacao);
        this.nomeTrilha = this.formataNomeTrilha();
        this.apelidoTrilha = this.formataApelidoTrilha();
        DatabaseTrilha.addTrilha(this);
    }

    private String formataApelidoTrilha() {
        return this.ocupacao + " " + this.numeroSequencialTrilha;
    }

    private String formataNomeTrilha() {
        return this.ocupacao + " " + this.empresaCliente.getNomeEmpresa() + " " + this.numeroSequencialTrilha + " " + this.ano;
    }

    private int getProximoNumeroSequencialTrilhaByOcupacao(String ocupacao) {
        List<Trilha> trilhas = DatabaseTrilha.getTrilhas();
        trilhas = trilhas.stream().filter(trilha -> trilha.getOcupacao()
                        .equals(ocupacao) && trilha.getEmpresaCliente()
                        .equals(this.empresaCliente))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return trilhas.size() == 0 ? 1 : trilhas.size() + 1;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public void setNotaSatisfacaoGeral(NotasEnum notaSatisfacaoGeral) {
        this.notaSatisfacaoGeral = notaSatisfacaoGeral;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public EmpresaCliente getEmpresaCliente() {
        return empresaCliente;
    }

    public int getEmpresaId() {
        return this.empresaCliente.getId();
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trilha)) return false;
        Trilha trilha = (Trilha) o;
        return getId() == trilha.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
