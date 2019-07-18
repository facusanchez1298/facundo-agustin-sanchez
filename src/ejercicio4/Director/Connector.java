package ejercicio4.Director;

import ejercicio4.AbstractBuilding;
import ejercicio4.Connection;

public class Conector {
    private AbstractBuilding abstractBuilding;

    public Conector(AbstractBuilding abstractBuilding){
        this.abstractBuilding = abstractBuilding;
    }

    public AbstractBuilding getAbstractBuilding() {
        return abstractBuilding;
    }

    public void setAbstractBuilding(AbstractBuilding abstractBuilding) {
        this.abstractBuilding = abstractBuilding;
    }

    public Connection conectarse(){
        return abstractBuilding.connectTo();
    }
}
