package entity;

import enums.PerfilDeAcessoEnum;
import enums.RegionalSenaiEnum;
import enums.SegmentoEmpresaEnum;
import exception.DocumentoException;
import exception.PermissaoException;
import utils.Validadores;

import java.util.ArrayList;
import java.util.List;

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
    private List<Trilha> trilhas = new ArrayList<>();

    public EmpresaCliente(String razaoSocial, String cnpj, String cidade, String estado, SegmentoEmpresaEnum segmentoEmpresa,
                          RegionalSenaiEnum regionalSenai, Usuario usuario) throws Exception {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.ADMINISTRADOR)) {
            throw new PermissaoException("Usuário não tem permissão para criar empresa");
        }
        this.razaoSocial = razaoSocial;
        this.cnpj = Validadores.validaCnpj(cnpj);
        this.cidade = cidade;
        this.estado = estado;
        this.segmentoEmpresa = segmentoEmpresa;
        this.regionalSenai = regionalSenai;
        this.isMatriz = true;
    }

    public EmpresaCliente(String razaoSocial, String cnpj, String cidade, String estado, SegmentoEmpresaEnum segmentoEmpresa,
                          RegionalSenaiEnum regionalSenai, String nomeFilial, Usuario usuario) throws Exception {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.ADMINISTRADOR)) {
            throw new PermissaoException("Usuário não tem permissão para criar empresa");
        }
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

    public void addTrilha(Trilha trilha) {
        this.trilhas.add(trilha);
    }
}
