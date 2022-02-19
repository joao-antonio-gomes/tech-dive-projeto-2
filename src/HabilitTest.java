import db.DatabaseEmpresaCliente;
import db.DatabaseModulo;
import db.DatabaseTrabalhador;
import db.DatabaseTrilha;
import entity.EmpresaCliente;
import entity.Modulo;
import entity.Trabalhador;
import entity.Trilha;
import enums.RegionalSenaiEnum;
import enums.SegmentoEmpresaEnum;
import enums.StatusModuloEnum;

import java.time.OffsetDateTime;

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

        Trabalhador trabalhadorJoao = new Trabalhador("Joao", "09355872925", empresaJoao, "Desenvolvimento", "Desenvolvedor");
        Trabalhador trabalhadorMaria = new Trabalhador("Maria", "09355872925", empresaJoao, "Desenvolvimento", "Desenvolvedor");
        Trabalhador trabalhadorFernanda = new Trabalhador("Fernanda", "09355872925", empresaJoao, "Desenvolvimento", "Desenvolvedor");
        trabalhadorJoao.addTrilha(trilhaEmpresaJoaoJava);
        trabalhadorMaria.addTrilha(trilhaEmpresaJoaoJava);
        trabalhadorJoao.addTrilha(trilhaEmpresaJoaoJavascript);

        DatabaseTrabalhador.getTrabalhadoresByTrilhaId(trilhaEmpresaJoaoJava.getId());

        int dias = 7;
        OffsetDateTime dataHoje = OffsetDateTime.now();
        while (dias > 0) {
            if (dataHoje.getDayOfWeek().getValue() < 6) {
                dias--;
            }
            dataHoje = dataHoje.plusDays(1);
        }
    }
}
