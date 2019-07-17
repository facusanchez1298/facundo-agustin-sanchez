package ejercicio4.Director;

import ejercicio4.AbstractConstructor;
import ejercicio4.Conexion;

public class Conector {
    private AbstractConstructor abstractConstructor;

    public Conector(AbstractConstructor abstractConstructor){
        this.abstractConstructor = abstractConstructor;
    }

    public AbstractConstructor getAbstractConstructor() {
        return abstractConstructor;
    }

    public void setAbstractConstructor(AbstractConstructor abstractConstructor) {
        this.abstractConstructor = abstractConstructor;
    }

    public Conexion conectarse(){
        return abstractConstructor.conectar();
    }
}
