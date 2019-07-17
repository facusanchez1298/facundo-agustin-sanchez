package ejercicio4.ConstructoresFinales;

import ejercicio4.AbstractConstructor;
import ejercicio4.Conexion;

public class ConexionSQLServer extends AbstractConstructor {

    public ConexionSQLServer(){
        super.conexion = new Conexion();
    }

    @Override
    public Conexion conectar() {

        conexion.setNombre("SQLServer");
        return conexion;
    }
}
