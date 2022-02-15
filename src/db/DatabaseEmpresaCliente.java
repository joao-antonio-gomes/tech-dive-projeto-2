package db;

import entity.EmpresaCliente;

import java.util.ArrayList;
import java.util.List;

public class DatabaseEmpresaCliente {
    private static List<EmpresaCliente> empresas = new ArrayList<>();

    public static List<EmpresaCliente> getEmpresas(){
        return empresas;
    }

    public static void addEmpresa(EmpresaCliente empresa){
        empresas.add(empresa);
    }
}
