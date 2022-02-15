package entity;

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
    private List<Modulo> modulos = new ArrayList<>();
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Trabalhador(String nome, String cpf, EmpresaCliente empresaCliente, String setor, String funcao, List<Modulo> modulos) throws Exception {
        this.id = numeroTrabalhadores++;
        this.nome = nome;
        this.cpf = Validadores.validaCpf(cpf);
        this.empresaCliente = empresaCliente;
        this.setor = setor;
        this.funcao = funcao;
        this.modulos = modulos;
        DatabaseTrabalhador.addTrabalhador(this);
    }

    public List<Trilha> getTrilhas() {
        List<Trilha> trilhas = new ArrayList<>();
        for (Modulo modulo : modulos) {
            Trilha trilha = modulo.getTrilha();
            if (!trilhas.contains(trilha)) {
                trilhas.add(trilha);
            }
        }
        return trilhas;
    }

    public void addModulo(Modulo modulo) {
        this.modulos.add(modulo);
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
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
}
