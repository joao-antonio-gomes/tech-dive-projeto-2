package entity;

import exception.DocumentoException;
import utils.Validadores;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Trabalhador {
    private Long id;
    private String nome;
    private String cpf;
    private EmpresaCliente empresaCliente;
    private String setor;
    private String funcao;
    private OffsetDateTime ultimaAlteracaoFuncao;
    private List<Modulo> modulos = new ArrayList<>();

    public Trabalhador(String nome, String cpf, EmpresaCliente empresaCliente, String setor, String funcao, List<Modulo> modulos) throws DocumentoException {
        this.nome = nome;
        this.cpf = Validadores.validaCpf(cpf);
        this.empresaCliente = empresaCliente;
        this.setor = setor;
        this.funcao = funcao;
        this.modulos = modulos;
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
