package utils;

import exception.DocumentoException;

public class ValidadoresTest {
    public static void main(String[] args) {
        System.out.println("Teste CNPJ Incorreto está passando: " + ValidadoresTest.testCnpjIncorreto());
        System.out.println("Teste CNPJ Formatado está passando: " + ValidadoresTest.testFormataCnpj());
    }

    private static boolean testCnpjIncorreto() {
        String cnpj = "12345678901234";

        try {
            Validadores.validaCnpj(cnpj);
        } catch (DocumentoException e) {
            return true;
        }

        return false;
    }

    private static boolean testFormataCnpj() {
        String cnpj = "01850147000133";

        try {
            return Validadores.validaCnpj(cnpj).equals("01.850.147/0001-33");
        } catch (DocumentoException e) {
            return false;
        }
    }
}
