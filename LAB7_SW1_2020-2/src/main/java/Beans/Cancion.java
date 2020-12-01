package Beans;

public class Cancion {
    private int idCancion;
    private String nombre_cancion;
    private String idBanda;

    public Cancion(int idCancion, String nombre_cancion, String idBanda) {
        this.idCancion = idCancion;
        this.nombre_cancion = nombre_cancion;
        this.idBanda = idBanda;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(String idBanda) {
        this.idBanda = idBanda;
    }
}
