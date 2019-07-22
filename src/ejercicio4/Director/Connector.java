package ejercicio4.Director;

import ejercicio4.AbstractBuilding;
import ejercicio4.Connection;

public class Connector {
  private AbstractBuilding abstractBuilding;

  /**
   * builder
   * @param abstractBuilding
   */
  public Connector(AbstractBuilding abstractBuilding){
    this.abstractBuilding = abstractBuilding;
  }
  /**
   * get the abstract builder
   * @return this.abstractBuilding
   */
  public AbstractBuilding getAbstractBuilding() {
    return abstractBuilding;
  }

  /**
   * setter this.abstractBuilding
   * @param abstractBuilding the new abstract building
   */
  public void setAbstractBuilding(AbstractBuilding abstractBuilding) {
    this.abstractBuilding = abstractBuilding;
  }
  /**
   * generate a connection object
   * @return Connection object
   */
  public Connection connect(){
    return abstractBuilding.connectTo();
  }
}
