package enums;

public enum SegmentoEmpresaEnum {
    ALIMENTOS_E_BEBIDAS(1, "Alimentos e Bebidas"),
    CELULOSE_E_PAPEL(2, "Celulose e Papel"),
    CONSTRUCAO(3, "Construção"),
    EQUIPAMENTOS_ELETRICOS(4, "Equipamentos Elétricos"),
    FARMACOS_E_EQUIPMAMENTOS_DE_SAUDE(5, "Farmacos e Equipamentos de Saúde"),
    FUMO(6, "Fumo"),
    INDUSTRIA_AUTOMOTICA(7, "Indústria Automotiva"),
    INDUSTRIA_CERAMICA(8, "Indústria Cerâmica"),
    INDUSTRIA_DIVERSA(9, "Indústria Diversa"),
    INDUSTRIA_EXTRATIVA(10, "Indústria Extrativa"),
    INDUSTRIA_GRAFICA(11, "Indústria Gráfica"),
    MADEIRA_E_MOVEIS(12, "Madeira e Móveis"),
    MAQUINAS_E_EQUIPAMENTOS(13, "Maquinas e Equipamentos"),
    METALMECANICA_E_METALURGIA(14, "Metalmecânica e Metalurgia"),
    OLEO_GAS_E_ELETRECIDADE(15, "Oleo, Gas e Eletrecidade"),
    PRODUTOS_QUIMICOS_E_PLASTICOS(16, "Produtos Químicos e Plásticos"),
    SANEAMENTO_BASICO(17, "Saneamento Básico"),
    TIC(18, "TIC"),
    TEXTIL_CONFECCAO_COURO_E_CALCADOS(19, "Textil, Confeção, Couro e Calçados");

    private int id;
    private String descricao;

    SegmentoEmpresaEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
