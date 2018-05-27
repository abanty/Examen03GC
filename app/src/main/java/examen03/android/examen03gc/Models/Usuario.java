package examen03.android.examen03gc.Models;

public class Usuario {

 private Integer ID;
 private String nombre;
 private Integer ncelular;

    public Usuario() {
    }

    public Usuario(Integer ID, String nombre, Integer ncelular) {
        this.ID = ID;
        this.nombre = nombre;
        this.ncelular = ncelular;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNcelular() {
        return ncelular;
    }

    public void setNcelular(Integer ncelular) {
        this.ncelular = ncelular;
    }
}
