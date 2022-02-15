package entity;

import db.DatabaseEmpresaCliente;
import enums.RegionalSenaiEnum;
import enums.SegmentoEmpresaEnum;
import utils.Validadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmpresaCliente {
    private static int numeroEmpresas = 0;
    private int id;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String estado;
    private SegmentoEmpresaEnum segmentoEmpresa;
    private RegionalSenaiEnum regionalSenai;
    private boolean isMatriz;
    private String nomeFilial;
    private List<Trilha> trilhas = new ArrayList<>();

    public EmpresaCliente(String razaoSocial, String cnpj, String cidade, String estado, SegmentoEmpresaEnum segmentoEmpresa,
                          RegionalSenaiEnum regionalSenai) throws Exception {
        this.id = ++numeroEmpresas;
        this.razaoSocial = razaoSocial;
        this.cnpj = Validadores.validaCnpj(cnpj);
        this.cidade = cidade;
        this.estado = estado;
        this.segmentoEmpresa = segmentoEmpresa;
        this.regionalSenai = regionalSenai;
        this.isMatriz = true;
        DatabaseEmpresaCliente.addEmpresa(this);
    }

    public EmpresaCliente(String razaoSocial, String cnpj, String cidade, String estado, SegmentoEmpresaEnum segmentoEmpresa,
                          RegionalSenaiEnum regionalSenai, String nomeFilial) throws Exception {
        this.id = ++numeroEmpresas;
        this.razaoSocial = razaoSocial;
        this.cnpj = Validadores.validaCnpj(cnpj);
        this.cidade = cidade;
        this.estado = estado;
        this.segmentoEmpresa = segmentoEmpresa;
        this.regionalSenai = regionalSenai;
        this.isMatriz = false;
        this.nomeFilial = nomeFilial;
        DatabaseEmpresaCliente.addEmpresa(this);
    }

    public String getNomeEmpresa() {
        if (!isMatriz) {
            return razaoSocial + " - " + nomeFilial;
        }
        return this.razaoSocial;
    }

    public void addTrilha(Trilha trilha) {
        this.trilhas.add(trilha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpresaCliente)) return false;
        EmpresaCliente that = (EmpresaCliente) o;
        return id == that.id && Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj);
    }
}
