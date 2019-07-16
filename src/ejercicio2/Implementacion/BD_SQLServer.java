package ejercicio2.Implementacion;

import ejercicio2.interfaz.IConectarBD;

public class BD_SQLServer implements IConectarBD {


    @Override
    public void conectar() {
        System.out.println("conectando a sql server");
    }

    @Override
    public void desconectar() {
        System.out.println("desconectando de sql server");
    }
}
