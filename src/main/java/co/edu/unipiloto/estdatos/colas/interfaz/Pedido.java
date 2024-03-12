/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.colas.interfaz;

import java.time.LocalDateTime;

public class Pedido {

    private LocalDateTime horaPedido;
    private Producto producto;
    private String direccion;
    private boolean esDomicilio;

    public Pedido(Producto producto, String direccion, boolean esDomicilio) {
        this.horaPedido = LocalDateTime.now();
        this.producto = producto;
        this.direccion = direccion;
        this.esDomicilio = esDomicilio;
    }

    public LocalDateTime getHoraPedido() {
        return horaPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean esDomicilio() {
        return esDomicilio;
    }
}
