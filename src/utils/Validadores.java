package utils;

import exception.DocumentoException;

import java.util.InputMismatchException;

public class Validadores {
    public static String formataCpf(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    public static String validaCpf(String cpf) throws DocumentoException {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            throw new DocumentoException("CPF deve conter 11 dígitos!");
        }

        int[] cpfArray = new int[11];
        for (int i = 0; i < cpf.length(); i++) {
            cpfArray[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpfArray[i] * (10 - i);
        }

        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        if (digito1 != cpfArray[9]) {
            throw new DocumentoException("CPF inválido!");
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += cpfArray[i] * (11 - i);
        }

        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        if (digito2 != cpfArray[10]) {
            throw new DocumentoException("CPF inválido!");
        }

        return formataCpf(cpf);
    }

    public static String validaEmail(String email) throws DocumentoException {
        if (!email.contains("@")) {
            throw new DocumentoException("E-mail inválido!");
        }

        String emailPrimeiraParte = email.split("@")[0];
        String emailSegundaParte = email.split("@")[1];

        if (!emailSegundaParte.contains(".")) {
            throw new DocumentoException("E-mail inválido!");
        }

        return email;
    }

    public static String validaSenha(String senha) throws DocumentoException {
        if (senha.length() < 8) {
            throw new DocumentoException("Senha deve conter no mínimo 8 caracteres!");
        }

        if (!senha.contains("[a-zA-Z]")) {
            throw new DocumentoException("Senha deve conter no mínimo uma letra!");
        }

        if (!senha.contains("[0-9]")) {
            throw new DocumentoException("Senha deve conter no mínimo um número!");
        }

        return senha;
    }

    public static String validaCnpj(String cnpj) throws DocumentoException {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            throw new DocumentoException("CNPJ deve ter 14 números!");
        }

        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999"))
            throw new DocumentoException("CNPJ não é válido!");

        int[] cnpjArray = new int[14];
        int[] numerosValidacaoCnpj = new int[] {
                5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2
        };
        for (int i = 0; i < cnpj.length(); i++) {
            cnpjArray[i] = Integer.parseInt(cnpj.substring(i, i + 1));
        }

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += cnpjArray[i] * numerosValidacaoCnpj[i];
        }

        int digito1 = soma % 11;
        if (digito1 > 9) {
            digito1 = 0;
        } else {
            digito1 = 11 - digito1;
        }

        if (digito1 != cnpjArray[12]) {
            throw new DocumentoException("CNPJ inválido!");
        }


        numerosValidacaoCnpj = new int[] {
                6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2
        };
        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += cnpjArray[i] * numerosValidacaoCnpj[i];
        }

        int digito2 = soma % 11;
        if (digito2 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - digito2;
        }

        if (digito2 != cnpjArray[13]) {
            throw new DocumentoException("CNPJ inválido!");
        }

        return (cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14));
    }
}
