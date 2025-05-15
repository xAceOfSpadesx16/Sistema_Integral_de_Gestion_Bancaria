package Clientes;

import java.util.List;

public abstract class Cliente {
    protected String nombre;
    protected String direccion;
    protected List<String> telefonos;

    public Cliente(String nombre, String direccion, List<String> telefonos){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }


    // ---- Getters y Setters ----

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarTelefono(String telefono){
        this.telefonos.add(telefono);
    }

    public void desvincularTelefono(String telefono){
        this.telefonos.remove(telefono);
    }

    public List<String> getTelefonos() {
        return this.telefonos;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
