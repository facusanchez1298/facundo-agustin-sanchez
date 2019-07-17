package ejercicio2.Implementacion;

import ejercicio2.interfaz.IConectarBD;

public class BD_MySQL implements IConectarBD {
    @Override
    public void conectar() {
        System.out.println("conectando a MySQLr");
    }

    @Override
    public void desconectar() {
        System.out.println("desconectando de MySQL");
    }
}
