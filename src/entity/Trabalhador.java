package entity;

import db.DatabaseModulo;
import db.DatabaseTrabalhador;
import utils.Validadores;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Trabalhador {
    private static int numeroTrabalhadores = 0;
    private int id;
    private String nome;
    private String cpf;
    private EmpresaCliente empresaCliente;
    private String setor;
    private String funcao;
    private OffsetDateTime ultimaAlteracaoFuncao;
    private List<Trilha> trilhas = new ArrayList<>();

    public Trabalhador(String nome, String cpf, EmpresaCliente empresaCliente, String setor, String funcao) throws Exception {
        this.id = numeroTrabalhadores++;
        this.nome = nome;
        this.cpf = Validadores.validaCpf(cpf);
        this.empresaCliente = empresaCliente;
        this.setor = setor;
        this.funcao = funcao;
        DatabaseTrabalhador.addTrabalhador(this);
    }

    public void setEmpresaCliente(EmpresaCliente empresaCliente) {
        this.empresaCliente = empresaCliente;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
        this.ultimaAlteracaoFuncao = OffsetDateTime.now();
    }

    public void addTrilha(Trilha trilha) {
        this.trilhas.add(trilha);
    }

    public List<Trilha> getTrilhasInscrito() {
        return trilhas;
    }

    public List<Modulo> getModulosInscrito() {
        List<Modulo> modulos = new ArrayList<>();
        for (Trilha trilha : trilhas) {
            modulos.addAll(DatabaseModulo.getModulosByIdTrilha(trilha.getId()));
        }
        return modulos;
    }

    public int getId() {
        return id;
    }

    public int getEmpresaId() {
        return this.empresaCliente.getId();
    }

    public List<Integer> getTrilhasId() {
        List<Integer> trilhasId = new ArrayList<>();
        for (Trilha trilha : trilhas) {
            trilhasId.add(trilha.getId());
        }
        return trilhasId;
    }
}
