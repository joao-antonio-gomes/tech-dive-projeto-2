package entity;

import enums.PerfilDeAcessoEnum;
import exception.DocumentoException;
import utils.Validadores;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Trabalhador {
    private Long id;
    private String nome;
    private String cpf;
    private EmpresaCliente empresaCliente;
    private String setor;
    private String funcao;
    private OffsetDateTime ultimaAlteracaoFuncao;
    private List<Modulo> modulos = new ArrayList<>();
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Trabalhador(String nome, String cpf, EmpresaCliente empresaCliente, String setor, String funcao, List<Modulo> modulos,
                       Usuario usuario) throws Exception {
        if (!usuario.isUsuarioComPerfilDeAcesso(PerfilDeAcessoEnum.RH)) {
            throw new Exception("Usuário não tem perfil de acesso para criar um trabalhador");
        }
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
