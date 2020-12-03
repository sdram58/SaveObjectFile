package com.catata.saveobjectfile;

import androidx.annotation.NonNull;

import java.io.Serializable;

class Producto implements Serializable {
    int id;
    String nombre;
    int cantidad;
    double precio_u;

    public Producto(int id, String nombre, int cantidad, double precio_u) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio_u = precio_u;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio_u() {
        return precio_u;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio_u(double precio_u) {
        this.precio_u = precio_u;
    }

    @NonNull
    @Override
    public String toString() {
        return "Producto{"+ "id=" +id +", nombre=" + nombre + ", cantidad="+cantidad +",precio_u="+precio_u +"}";
    }
}
