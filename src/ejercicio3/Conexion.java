package ejercicio3;

public class Conexion {

    /**
     * muestra si estamos o no conectados a la base de datos
     */
    private boolean conectado;

    //region getters y Setters

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    //endregion

}
