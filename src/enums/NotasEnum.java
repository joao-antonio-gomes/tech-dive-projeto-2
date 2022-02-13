package enums;

public enum NotasEnum {
    PESSIMO("1"),
    RUIM("2"),
    REGULAR("3"),
    BOM("4"),
    OTIMO("5");

    private String nota;

    NotasEnum(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }
}
