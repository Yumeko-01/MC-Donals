/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.colas.interfaz;

/**
 *
 * @author medin
 */
public class Producto {

    private String nombre;
    private long tiempoPreparacion;
    private double costo;

    public Producto(String nombre, long tiempoPreparacion, double costo) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public double getCosto() {
        return costo;
    }
}
