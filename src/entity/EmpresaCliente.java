package entity;

import enums.RegionalSenaiEnum;
import enums.SegmentoEmpresaEnum;
import exception.DocumentoException;
import utils.Validadores;

public class EmpresaCliente {
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String estado;
    private SegmentoEmpresaEnum segmentoEmpresa;
    private RegionalSenaiEnum regionalSenai;
    private boolean isMatriz;
    private String nomeFilial;

    public EmpresaCliente(String razaoSocial, String cnpj, String cidade, String estado, SegmentoEmpresaEnum segmentoEmpresa, RegionalSenaiEnum regionalSenai) throws DocumentoException {
        this.razaoSocial = razaoSocial;
        this.cnpj = Validadores.validaCnpj(cnpj);
        this.cidade = cidade;
        this.estado = estado;
        this.segmentoEmpresa = segmentoEmpresa;
        this.regionalSenai = regionalSenai;
        this.isMatriz = true;
    }

    public EmpresaCliente(String razaoSocial, String cnpj, String cidade, String estado, SegmentoEmpresaEnum segmentoEmpresa, RegionalSenaiEnum regionalSenai, String nomeFilial) throws DocumentoException {
        this.razaoSocial = razaoSocial;
        this.cnpj = Validadores.validaCnpj(cnpj);
        this.cidade = cidade;
        this.estado = estado;
        this.segmentoEmpresa = segmentoEmpresa;
        this.regionalSenai = regionalSenai;
        this.isMatriz = false;
        this.nomeFilial = nomeFilial;
    }

    public String getNomeEmpresa() {
        if (!isMatriz) {
            return razaoSocial + " - " + nomeFilial;
        }
        return this.razaoSocial;
    }
}
