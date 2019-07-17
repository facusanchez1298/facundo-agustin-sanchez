package ejercicio4.ConstructoresFinales;

import ejercicio4.AbstractConstructor;
import ejercicio4.Conexion;

public class ConexionMySQL extends AbstractConstructor {

    public ConexionMySQL(){
        super.conexion = new Conexion();
    }

    @Override
    public Conexion conectar() {
        conexion.setNombre("MY SQL");
        return conexion;
    }

}
