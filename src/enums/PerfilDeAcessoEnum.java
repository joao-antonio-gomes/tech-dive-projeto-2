package enums;

public enum PerfilDeAcessoEnum {
    ADMINISTRADOR(1, "Administrador"),
    OPERACIONAL(2, "Operacional"),
    RH(3, "RH");

    private int codigo;
    private String descricao;

    PerfilDeAcessoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }
}
