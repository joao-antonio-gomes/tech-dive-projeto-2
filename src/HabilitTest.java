import db.DatabaseEmpresaCliente;
import db.DatabaseModulo;
import db.DatabaseTrabalhador;
import db.DatabaseTrilha;
import entity.EmpresaCliente;
import entity.Modulo;
import entity.Trilha;
import enums.RegionalSenaiEnum;
import enums.SegmentoEmpresaEnum;
import enums.StatusModuloEnum;

public class HabilitTest {
    public static void main(String[] args) throws Exception {
        EmpresaCliente empresaJoao = new EmpresaCliente("Joao Antonio Gomes ME", "05.555.382/0001-33", "São José", "Santa Catarina", SegmentoEmpresaEnum.ALIMENTOS_E_BEBIDAS,
                RegionalSenaiEnum.LITORAL_SUL);

        Trilha trilhaEmpresaJoaoJava = new Trilha(empresaJoao, "Java");
        Trilha trilhaEmpresaJoaoJavascript = new Trilha(empresaJoao, "Javascript");
        Trilha trilhaEmpresaJoaoJava2 = new Trilha(empresaJoao, "Java");

        Modulo modulol1Trilha2 = new Modulo(trilhaEmpresaJoaoJava, "POO - Javascript", StatusModuloEnum.CURSO_NAO_INICIADO, 0, "Programação Orientada a Objeto",
                "Saber definir classes, polimorfismo, herança, encapsulamento");
        Modulo modulol1Trilha1 = new Modulo(trilhaEmpresaJoaoJavascript, "POO", StatusModuloEnum.CURSO_NAO_INICIADO, 0, "Programação Orientada a Objeto",
                "Saber definir classes, polimorfismo, herança, encapsulamento");
        Modulo modulol2Trilha1 = new Modulo(trilhaEmpresaJoaoJava, "SQL", StatusModuloEnum.CURSO_NAO_INICIADO, 0, "Banco de Dados",
                "Saber definir DDL e DML");

        DatabaseTrilha.getTrilhas();
        DatabaseModulo.getModulos();
    }
}
